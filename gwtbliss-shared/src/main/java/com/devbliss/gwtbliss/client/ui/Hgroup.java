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

package com.devbliss.gwtbliss.client.ui;

import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * A HTML5 Hgroup Element
 *
 * @see <a
 *      href="http://www.whatwg.org/specs/web-apps/current-work/multipage/sections.html#the-hgroup-element">W3C
 *      Spec Draft</a>
 *
 * @author christoph.ulrich@devbliss.com
 *
 */
public class Hgroup extends HTMLPanel {

  private static final String HTML_TAG = "hgroup";

  /**
   * Create empty section element
   */
  public Hgroup() {
    this("");
  }

  /**
   * Create hgroup element with html content
   *
   * @param html content that will be nested in element
   */
  public Hgroup(final String html) {
    super(HTML_TAG, html);
  }

}
