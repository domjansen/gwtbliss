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
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * Tests for the {@link DefinitionDefinition}.
 * 
 *  @author dominic.jansen@devbliss.com
 * 
 */
public class DefinitionDefinitionGWTTest extends GWTTestCase {

  private static final String TEXT = "Text";

  @Override
  public String getModuleName() {
    return "com.devbliss.gwtbliss.GwtblissUI";
  }

  public void testConstruction() {

    DefinitionDefinition dd = new DefinitionDefinition();

    assertTrue("dd".equalsIgnoreCase(dd.getElement().getTagName()));
    assertTrue("<dd></dd>".equalsIgnoreCase(dd.toString()));

  }

  public void testConstruction_withText() {

    DefinitionDefinition dd = new DefinitionDefinition(TEXT);

    assertTrue("dd".equalsIgnoreCase(dd.getElement().getTagName()));
    String dtAsString = "<dd>" + TEXT + "</dd>";
    assertTrue(dtAsString.equalsIgnoreCase(dd.toString()));

  }

  /**
   * Test
   * {@link DefinitionDefinition.#add(com.google.gwt.user.client.ui.Widget)}
   */
  public void testAdd() {
    FlowPanel div = new FlowPanel();
    DefinitionDefinition dd = new DefinitionDefinition();
    dd.add(div);
    assertTrue(dd.toString().equalsIgnoreCase("<dd><div></div></dd>"));
  }

  /**
   * Test
   * {@link DefinitionDefinition.#clear())}
   */
  public void testClear() {
    FlowPanel div = new FlowPanel();
    DefinitionDefinition dd = new DefinitionDefinition();
    assertTrue(dd.toString().equalsIgnoreCase("<dd></dd>"));
    dd.add(div);
    assertTrue(dd.toString().equalsIgnoreCase("<dd><div></div></dd>"));
    dd.clear();
    assertTrue(dd.toString().equalsIgnoreCase("<dd></dd>"));
  }

  /**
   * Test
   * {@link DefinitionDefinition.#setInnerText(String))}
   */
  public void testSetInnerText() {
    DefinitionDefinition dd = new DefinitionDefinition();
    dd.setInnerText(TEXT);
    assertTrue(dd.toString().equalsIgnoreCase("<dd>" + TEXT + "</dd>"));
  }

}
