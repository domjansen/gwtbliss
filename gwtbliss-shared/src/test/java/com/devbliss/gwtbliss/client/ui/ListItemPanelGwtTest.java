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

import com.google.gwt.junit.client.GWTTestCase;

/**
 *
 * @author <a href="mailto:jb@barop.de">Johannes Barop</a>
 *
 */
public class ListItemPanelGwtTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "com.devbliss.gwtbliss.Shared";
  }

  /**
   * Check that an {@link ListItemPanel} properly created.
   */
  public void testConstruction() {
    ListItemPanel listItemPanel = new ListItemPanel();
    assertTrue("li".equalsIgnoreCase(listItemPanel.getElement().getTagName()));
    assertTrue("<li></li>".equalsIgnoreCase(listItemPanel.toString()));

    listItemPanel = new ListItemPanel("");
    assertTrue("li".equalsIgnoreCase(listItemPanel.getElement().getTagName()));
    assertTrue("<li></li>".equalsIgnoreCase(listItemPanel.toString()));

    listItemPanel = new ListItemPanel("<a></a>");
    assertTrue("li".equalsIgnoreCase(listItemPanel.getElement().getTagName()));
    assertTrue("<li><a></a></li>".equalsIgnoreCase(listItemPanel.toString()));
  }

}
