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
import com.google.gwt.user.client.ui.TextBox;

/**
 *
 * @author <a href="mailto:jb@barop.de">Johannes Barop</a>
 *
 */
public class FormLabelGwtTest extends GWTTestCase {

  private TextBox textBox01;
  private FormLabel formLabel01;

  private TextBox textBox02;
  private FormLabel formLabel02;

  private TextBox textBox03;
  private FormLabel formLabel03;

  @Override
  public String getModuleName() {
    return "com.devbliss.gwtbliss.Shared";
  }

  @Override
  protected void gwtSetUp() throws Exception {
    super.gwtSetUp();

    textBox01 = new TextBox();
    formLabel01 = new FormLabel(textBox01);

    textBox02 = new TextBox();
    formLabel02 = new FormLabel(textBox02);

    textBox03 = new TextBox();
    formLabel03 = new FormLabel(textBox03);
  }

  /**
   * Check that the widgets created the correct element.
   */
  public void testTag() {
    assertEquals("label", formLabel01.getElement().getTagName().toLowerCase());
  }

  /**
   * Check the text handling of the {@link FormLabel} widget.
   */
  public void testText() {
    String someText = "someText";

    assertEquals("", formLabel01.getElement().getInnerText());
    formLabel01.setText(someText);
    assertEquals(someText, formLabel01.getElement().getInnerText());
  }

  /**
   * Check that the 'for' attribute of the label matches the 'id' attribute of the referenced
   * widget.
   */
  public void testIds() {
    assertNotNull(formLabel01.getElement().getAttribute("for"));
    assertEquals(formLabel01.getElement().getAttribute("for"), textBox01.getElement().getAttribute("id"));

    assertNotNull(formLabel02.getElement().getAttribute("for"));
    assertEquals(formLabel02.getElement().getAttribute("for"), textBox02.getElement().getAttribute("id"));

    assertNotNull(formLabel03.getElement().getAttribute("for"));
    assertEquals(formLabel03.getElement().getAttribute("for"), textBox03.getElement().getAttribute("id"));
  }

  /**
   * Check that every label/widget has an unique 'id'.
   */
  public void testUniqueIds() {
    assertFalse(formLabel01.getElement().getAttribute("for").equals(
        formLabel02.getElement().getAttribute("for")));
    assertFalse(formLabel01.getElement().getAttribute("for").equals(
        formLabel03.getElement().getAttribute("for")));
    assertFalse(formLabel02.getElement().getAttribute("for").equals(
        formLabel03.getElement().getAttribute("for")));
  }

}
