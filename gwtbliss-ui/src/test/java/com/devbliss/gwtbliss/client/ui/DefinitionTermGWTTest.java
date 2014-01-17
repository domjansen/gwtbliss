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
 * Tests for the {@link DefinitionTerm}.
 * 
 *  @author dominic.jansen@devbliss.com
 * 
 */
public class DefinitionTermGWTTest extends GWTTestCase {

  private static final String TEXT = "Text";

  @Override
  public String getModuleName() {
    return "com.devbliss.gwtbliss.GwtblissUI";
  }

  public void testConstruction() {

    DefinitionTerm dt = new DefinitionTerm();

    assertTrue("dt".equalsIgnoreCase(dt.getElement().getTagName()));
    assertTrue("<dt></dt>".equalsIgnoreCase(dt.toString()));

  }

  public void testConstruction_withText() {

    DefinitionTerm dt = new DefinitionTerm(TEXT);

    assertTrue("dt".equalsIgnoreCase(dt.getElement().getTagName()));
    String dtAsString = "<dt>" + TEXT + "</dt>";
    assertTrue(dtAsString.equalsIgnoreCase(dt.toString()));

  }

  /**
   * Test
   * {@link DefinitionTerm.#add(com.google.gwt.user.client.ui.Widget)}
   */
  public void testAdd() {
    FlowPanel div = new FlowPanel();
    DefinitionTerm dt = new DefinitionTerm();
    dt.add(div);
    assertTrue(dt.toString().equalsIgnoreCase("<dt><div></div></dt>"));
  }

  /**
   * Test
   * {@link DefinitionTerm.#clear())}
   */
  public void testClear() {
    FlowPanel div = new FlowPanel();
    DefinitionTerm dt = new DefinitionTerm();
    assertTrue(dt.toString().equalsIgnoreCase("<dt></dt>"));
    dt.add(div);
    assertTrue(dt.toString().equalsIgnoreCase("<dt><div></div></dt>"));
    dt.clear();
    assertTrue(dt.toString().equalsIgnoreCase("<dt></dt>"));
  }

  /**
   * Test
   * {@link DefinitionTerm.#setInnerText(String))}
   */
  public void testSetInnerText() {
    DefinitionTerm dt = new DefinitionTerm();
    dt.setInnerText(TEXT);
    assertTrue(dt.toString().equalsIgnoreCase("<dt>" + TEXT + "</dt>"));
  }

}
