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

import com.google.gwt.dom.client.Document;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

/**
 * A <code>label</code> tag which is associated with another widget.
 *
 * <p>
 * Every label tag gets associated with its own unique id.
 * </p>
 *
 * <h2>Usage:</h2>
 *
 * <pre>
 * &lt;g:TextBox ui:field="myTextBox" /&gt;
 * &lt;p:FormLabel on="{myTextBox}" text="My labeled TextBox:" /&gt
 * </pre>
 *
 * @author <a href="mailto:jb@barop.de">Johannes Barop</a>
 *
 */
public class FormLabel extends Widget implements HasText {

  /**
   * Construct a new {@link FormLabel}.
   *
   * <p>
   * The <code>id</code> attribute of the given widget will be set to an unique id.
   * </p>
   *
   * @param on The widget which should referenced by this label
   */
  @UiConstructor
  public FormLabel(final Widget on) {
    on.getElement().setId(DOM.createUniqueId());
    setElement(Document.get().createLabelElement());
    getElement().setAttribute("for", on.getElement().getId());
  }

  @Override
  public void setText(final String text) {
    getElement().setInnerText(text);
  }

  @Override
  public String getText() {
    return getElement().getInnerText();
  }

}
