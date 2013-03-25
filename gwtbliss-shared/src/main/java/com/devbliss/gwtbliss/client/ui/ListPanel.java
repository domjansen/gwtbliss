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
import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.WidgetCollection;

/**
 * Panel for HTML lists.
 *
 * <p>
 * Basically creates an UL tag and can contain other child LI widgets.
 * </p>
 *
 * @author <a href="mailto:jb@barop.de">Johannes Barop</a>
 *
 */
public class ListPanel extends HTMLPanel implements InsertPanel {

  public ListPanel() {
    this("");
  }

  public ListPanel(final String html) {
    super("ul", html);
  }

  @Override
  public WidgetCollection getChildren() {
    return super.getChildren();
  }

  @Override
  public void insert(final Widget w, final int beforeIndex) {
    insert(w, getElement(), beforeIndex, true);
  }

}
