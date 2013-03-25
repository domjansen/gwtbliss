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

package com.devbliss.gwtbliss.client;

/**
 * A typed command to use in a command/callback pattern.
 *
 * @param <T> Type which gets passed to the {@link #execute(Object)
 *
 * @author <a href="mailto:jb@barop.de">Johannes Barop</a>
 *
 */
public interface TypedCommand<T> {

  /**
   * Execute the command/callback with the given object passed in.
   */
  void execute(T object);

}
