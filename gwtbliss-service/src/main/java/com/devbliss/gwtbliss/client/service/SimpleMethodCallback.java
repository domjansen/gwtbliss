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

import com.google.gwt.logging.client.LogConfiguration;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.logging.Logger;

/**
 * Aim: Avoids boilerplate code and replaces MethodCallback<T>
 *
 * Actually, we do not want that service users must implement onFailure Method. If a failure occurs
 * it will be catched way before. By design.
 *
 * Example usage: <code>
 * profileService.getProfile(new SimpleMethodCallback<ProfileDto>() {
 *
 * @Override public void onSuccess(Method method, ProfileDto response) { setCurrentTab(response); }
 *           }); </code>
 *
 *           OLD USAGE => WE NEEDED TO IMPLEMENT THE USELESS onFailure method... <code>
 * profileService.getProfile(new MethodCallback<ProfileDto>() {
 *
 * @Override public void onSuccess(Method method, ProfileDto response) { setCurrentTab(response); }
 *
 * @Override public void onFailure(Method method, Throwable exception) {
 *           Window.alert("failure getting dto => not logged in?"); } });
 *
 *           </code>
 *
 * @param <T>
 *
 * @author raphael@raphaelbauer.com
 *
 */
public abstract class SimpleMethodCallback<T> implements MethodCallback<T> {

  /**
   * This method should be implemented by user of service.
   */
  @Override
  public abstract void onSuccess(Method method, T response);

  /**
   * Must NOT be implemented by user of service.
   */
  @Override
  public final void onFailure(final Method method, final Throwable exception) {
    if (LogConfiguration.loggingIsEnabled()) {
      Logger.getLogger(SimpleMethodCallback.class.getName()).severe(
          "ERROR in " + this.getClass() + "#onFailure. This should not happen "
              + "when using this callback type. " + exception.getMessage());
    }
  }

}
