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

import org.fusesource.restygwt.client.Method;

/**
 * Callback for operations where we do not care for the response.
 *
 * @param <T>
 *
 * @author hschuetz
 */
public class FireAndForgetCallback<T> extends SimpleMethodCallback<T> {

  @Override
  public void onSuccess(final Method method, final T response) {
    // no op
  }

}
