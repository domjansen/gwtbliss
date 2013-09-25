/*
 * Copyright 2013, devbliss GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.devbliss.gwtbliss.client.service;

import com.devbliss.gwtbliss.client.TypedCommand;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Base class for all cached providers. A provider retrieves data via a RestyGWT service call and
 * stores this data for subsequent calls. It ensures that only one call to the service is made at
 * all times due to a queued callback mechanism.
 *
 * It is generally a good idea to bind all your providers as Singletons. The recommended way to do
 * this is to add the @Singleton annotation on top of your class.
 *
 * @param <T> the data type to be cached.
 *
 * @author david.richard@devbliss.com
 *
 */
public abstract class CachedProvider<T> {

  private T cachedData;
  private boolean fetching;
  private final Queue<TypedCommand<T>> queue = new LinkedList<TypedCommand<T>>();

  /**
   * Fetch the data from the service. This call is async because the first invocation will have to
   * talk to the service while subsequent calls will rely on a cached instance of the data.
   *
   * @param callback
   */
  public void get(final TypedCommand<T> callback) {
    if (cachedData != null) {
      callback.execute(cachedData);
    } else {
      getAsync(callback);
    }
  }

  /**
   * Adds the callback to a queue and asks the service for the data if this is the first get() call.
   * When the service responds all callbacks that have been registered during the fetching time are
   * executed. This avoids asking the service more than once during the time where the payload is on
   * its way.
   *
   * @param callback
   */
  private void getAsync(final TypedCommand<T> callback) {
    queue.add(callback);

    if (!fetching) {
      fetching = true;
      fetchData(new SimpleMethodCallback<T>() {
        @Override
        public void onSuccess(final Method method, final T response) {
          fetching = false;
          cachedData = response;

          // execute all callbacks and clear queue
          for (TypedCommand<T> callback; (callback = queue.poll()) != null;) {
            callback.execute(response);
          }
        }
      });
    }
  }

  /**
   * Fetches the data via a RestyGWT service call and passes the callback to the service call.
   *
   * @param callback
   */
  protected abstract void fetchData(final MethodCallback<T> callback);

  /**
   * Invalidates (clears) the cache. The next call to get() will ask the service again.
   */
  public void invalidate() {
    cachedData = null;
  }

}
