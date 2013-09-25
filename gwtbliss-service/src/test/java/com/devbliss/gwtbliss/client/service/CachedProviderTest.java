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
import com.devbliss.gwtbliss.client.service.CachedProvider;

import static junit.framework.Assert.assertEquals;

import java.util.Timer;
import java.util.TimerTask;

import org.fusesource.restygwt.client.MethodCallback;
import org.junit.Before;
import org.junit.Test;

/**
 * @author david.richard@devbliss.com
 */
public class CachedProviderTest {

  private CachedProvider<String> cachedProvider;
  private int callbackCount = 0;
  private TypedCommand<String> callback = new TypedCommand<String>() {

    public void execute(String object) {
      assertEquals("success", object);
      callbackCount += 1;
    }

  };

  private int fetchDataCount = 0;

  @Before
  public void setUp() {
    cachedProvider = new CachedProvider<String>() {
      @Override
      protected void fetchData(final MethodCallback<String> callback) {
        fetchDataCount += 1;

        // introduce slight delay to simulate asyncness
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
          @Override
          public void run() {
            callback.onSuccess(null, "success");
          }
        }, 250);
      }
    };
  }

  @Test
  public void testGet() throws Exception {
    cachedProvider.get(callback);
    Thread.sleep(300);
    assertEquals(1, fetchDataCount);
    assertEquals(1, callbackCount);
  }

  @Test
  public void testGetCached() throws Exception {
    // fetch and get once
    cachedProvider.get(callback);
    Thread.sleep(300);
    assertEquals(1, fetchDataCount);

    // never fetch again
    cachedProvider.get(callback);
    cachedProvider.get(callback);
    assertEquals(1, fetchDataCount);

    // should have executed all callbacks
    assertEquals(3, callbackCount);
  }

  @Test
  public void testGetQueued() throws Exception {
    // get 3 times
    cachedProvider.get(callback);
    cachedProvider.get(callback);
    cachedProvider.get(callback);

    // should only fetch once
    assertEquals(1, fetchDataCount);

    // should have executed all callbacks
    Thread.sleep(300);
    assertEquals(3, callbackCount);
  }

  @Test
  public void testInvalidate() throws Exception {
    // ask once, fetch once
    cachedProvider.get(callback);
    assertEquals(1, fetchDataCount);

    // wait for first answer
    Thread.sleep(300);

    // invalidate and ask again, now it should be fetched twice
    cachedProvider.invalidate();
    cachedProvider.get(callback);
    assertEquals(2, fetchDataCount);

    // wait a bit, all callbacks should have been called
    Thread.sleep(300);
    assertEquals(2, callbackCount);
  }
}
