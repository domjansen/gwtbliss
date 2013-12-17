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

package activityplayer.widget.instruction;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * A panel that contains a definition definition in a <dd> tag of a definition list {@link DefinitionListPanel}.
 * 
 * The <dd> tag is used in conjunction with <dl> (defines a description list) and <dt> (defines terms/names).
 * 
 * @author dominic.jansen@devbliss.com
 *
 */
public class DefinitionDefinition extends ComplexPanel implements InsertPanel.ForIsWidget {

  /**
   * Creates an empty DefinitionListPanel.
   */
  public DefinitionDefinition() {

    Element dd = DOM.createElement("dd");
    setElement(dd);
  }

  /**
   * Creates a DefinitionListPanel with innerText = text.
   */
  public DefinitionDefinition(String text) {
    Element dd = DOM.createElement("dd");
    setElement(dd);
    setInnerText(text);

  }

  /**
   * Adds a new child widget to the panel.
   * 
   * @param w the widget to be added
   */
  @Override
  public void add(Widget w) {
    add(w, getElement());
  }

  @Override
  public void clear() {
    Node child = getElement().getFirstChild();
    while (child != null) {
      getElement().removeChild(child);
      child = getElement().getFirstChild();
    }

  }

  public void insert(IsWidget w, int beforeIndex) {
    insert(asWidgetOrNull(w), beforeIndex);
  }

  /**
   * Inserts a widget before the specified index.
   * 
   * @param w the widget to be inserted
   * @param beforeIndex the index before which it will be inserted
   * @throws IndexOutOfBoundsException if <code>beforeIndex</code> is out of
   *           range
   */
  public void insert(Widget w, int beforeIndex) {
    insert(w, getElement(), beforeIndex, true);
  }

  /**
   * Sets the label's content to the given text.
   * 
   * @param text the widget's new text
   */
  public void setInnerText(String text) {
    setInnerTextOrHtml(text, false);
  }

  private void setInnerTextOrHtml(String content, boolean isHtml) {
    if (isHtml) {
      getElement().setInnerHTML(content);
    } else {
      getElement().setInnerText(content);
    }
  }

}
