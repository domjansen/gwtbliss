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
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Tests for the {@link DefinitionListPanel}.
 * 
 *  @author dominic.jansen@devbliss.com
 * 
 */
public class DefinitionListPanelGWTTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "com.devbliss.gwtbliss.GwtblissUI";
  }

  public void testConstruction() {

    DefinitionListPanel definitionListPanel = new DefinitionListPanel();
    RootPanel.get().add(definitionListPanel);

    assertTrue(RootPanel.get().getElement().getInnerHTML().contains("<dl></dl>"));
    assertTrue("dl".equalsIgnoreCase(definitionListPanel.getElement().getTagName()));
    assertTrue("<dl></dl>".equalsIgnoreCase(definitionListPanel.toString()));

  }

  /**
   * Test
   * {@link DefinitionListPanel.#clear())}
   */
  public void testClear() {
    DefinitionListPanel definitionListPanel = new DefinitionListPanel();
    assertTrue(definitionListPanel.toString().equalsIgnoreCase("<dl></dl>"));
    DefinitionTerm dt = new DefinitionTerm();
    DefinitionDefinition dd = new DefinitionDefinition();
    definitionListPanel.add(dt, dd);
    assertTrue(definitionListPanel.toString().equalsIgnoreCase("<dl><dt></dt><dd></dd></dl>"));
    definitionListPanel.clear();
    assertTrue(definitionListPanel.toString().equalsIgnoreCase("<dl></dl>"));
  }

  /**
   * Test
   * {@link DefinitionListPanel.#add(DefinitionTerm, DefinitionDefinition)}
   */
  public void testAddDtDd() {
    DefinitionListPanel definitionListPanel = new DefinitionListPanel();
    DefinitionTerm dt = new DefinitionTerm();
    DefinitionDefinition dd = new DefinitionDefinition();
    definitionListPanel.add(dt, dd);
    assertEquals("<dl><dt></dt><dd></dd></dl>", definitionListPanel.toString());
  }

  /**
   * Test
   * {@link DefinitionListPanel.#add(com.google.gwt.user.client.ui.Widget)}
   */
  public void testAdd_Dt() {
    DefinitionListPanel definitionListPanel = new DefinitionListPanel();
    DefinitionTerm dt = new DefinitionTerm();
    definitionListPanel.add(dt);
    assertEquals("<dl><dt></dt></dl>", definitionListPanel.toString());
  }

  /**
   * Test
   * {@link DefinitionListPanel.#add(com.google.gwt.user.client.ui.Widget)}
   */
  public void testAdd_DtAndDd() {
    DefinitionListPanel definitionListPanel = new DefinitionListPanel();
    DefinitionTerm dt = new DefinitionTerm();
    DefinitionDefinition dd = new DefinitionDefinition();
    definitionListPanel.add(dt);
    definitionListPanel.add(dd);
    assertEquals("<dl><dt></dt><dd></dd></dl>", definitionListPanel.toString());
  }

  /**
   * Test
   * {@link DefinitionListPanel.#add(com.google.gwt.user.client.ui.Widget)}
   */
  public void testAdd_Dd() {
    DefinitionListPanel definitionListPanel = new DefinitionListPanel();
    DefinitionDefinition dd = new DefinitionDefinition();
    try {
      definitionListPanel.add(dd);
    } catch (Exception e) {
      assertTrue(e instanceof IllegalStateException);
      return;
    }
    fail();
  }

  /**
  * Test
  * {@link DefinitionListPanel.#add(com.google.gwt.user.client.ui.Widget)}
  */
  public void testAdd_Widget() {
    DefinitionListPanel definitionListPanel = new DefinitionListPanel();
    Button button = new Button();
    try {
      definitionListPanel.add(button);
    } catch (AssertionError e) {
      return;
    }
    fail();
  }

  /**
   * Test
   * {@link DefinitionListPanel.#add(com.google.gwt.user.client.ui.Widget)}
   */
  public void testAdd_DtDdDd() {
    DefinitionListPanel definitionListPanel = new DefinitionListPanel();
    DefinitionTerm dt = new DefinitionTerm();
    DefinitionDefinition dd = new DefinitionDefinition();
    DefinitionDefinition dd2 = new DefinitionDefinition();

    definitionListPanel.add(dt);
    definitionListPanel.add(dd);
    try {
      definitionListPanel.add(dd2);
    } catch (AssertionError e) {
      return;
    }
    fail();
  }

  /**
   * Test
   * {@link DefinitionListPanel.#add(com.google.gwt.user.client.ui.Widget)}
   */
  public void testAdd_DtDt() {
    DefinitionListPanel definitionListPanel = new DefinitionListPanel();
    DefinitionTerm dt = new DefinitionTerm();
    definitionListPanel.add(dt);
    DefinitionTerm dt2 = new DefinitionTerm();
    try {
      definitionListPanel.add(dt2);
    } catch (AssertionError e) {
      return;
    }
    fail();
  }

}
