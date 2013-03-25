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

package client;

/**
 * Place tokens for the common module.
 *
 * @author <a href="mailto:jb@barop.de">Johannes Barop</a>
 */
public class ApplicationPlaceTokens {

  public static final String NOT_FOUND = "/notfound";

  public static final String INDEX = "/";

  public static String notFound() {
    return NOT_FOUND;
  }

  public static String index() {
    return INDEX;
  }

}
