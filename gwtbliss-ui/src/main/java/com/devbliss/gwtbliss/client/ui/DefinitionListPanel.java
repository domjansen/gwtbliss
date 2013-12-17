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

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Node;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * 
 * A panel that contains a description list, and which can attach child widgets {@link DefinitionTerm} and {@link DefinitionDefinition}.
 *
 * A description list is a list of terms/names, with a description of each term/name.
 * The <dl> tag defines a description list. 
 * The <dl> tag is used in conjunction with <dt> (defines terms/names) {@link DefinitionTerm} and <dd> (describes each term/name) {@link DefinitionDefinition}.
 * 
 * Example:
 * <dl>
 *    <dt>Elephant</dt>
 *    <dd>big grey animal</dd>
 *    <dt>C. elegans</dt>
 *    <dd>small transparent nematode</dd>
 * </dl> 
 *
 * @author dominic.jansen@devbliss.com
 *
 */
public class DefinitionListPanel extends ComplexPanel implements InsertPanel.ForIsWidget {

  /**
   * Creates an empty DefinitionListPanel.
   */
  public DefinitionListPanel() {
    setElement(Document.get().createDLElement());

  }

  /**
   * Adds a new child widget to the panel.
   * 
   * @param w the widget to be added
   */
  @Override
  public void add(Widget w) {

    assertWidget(w);
    add(w, getElement());
  }

  /**
   * Verifies some constraints due to a definition list.
   * @param w
   */
  private void assertWidget(Widget w) {

    assert (w.getElement().getTagName().equalsIgnoreCase("dt") || w.getElement().getTagName().equalsIgnoreCase(
        "dd")) : "DefinitionListPanel can only accept tag \"dd\" or \"dt\". Please use DefinitionDefinition and DefinitionTerm.";

    if (w.getElement().getTagName().equalsIgnoreCase("dd")) {
      if (getElement().hasChildNodes()) {
        assert (getElement().getLastChild().getNodeName().equalsIgnoreCase("dt")) : "A <dd> can only inserted behind a <dt>.";
      } else {
        throw new IllegalStateException("A <dd> can only inserted behind a <dt>.");
      }
    } else if (w.getElement().getTagName().equalsIgnoreCase("dt")) {
      if (getElement().hasChildNodes()) {
        assert (getElement().getLastChild().getNodeName().equalsIgnoreCase("dd")) : "A <dt> can only inserted behind a <dl> or <dt>.";
      }
    }
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

  public void add(DefinitionTerm term, DefinitionDefinition definition) {
    getElement().appendChild(term.getElement());
    getElement().appendChild(definition.getElement());
  }

}
