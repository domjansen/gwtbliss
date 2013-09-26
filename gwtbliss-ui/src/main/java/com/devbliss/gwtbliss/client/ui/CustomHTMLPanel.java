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
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * TODO: clean up, write test
 */
public class CustomHTMLPanel extends ComplexPanel implements AcceptsOneWidget {

  private IsWidget widget = null;

  public CustomHTMLPanel() {
  }

  @UiConstructor
  public CustomHTMLPanel(final String tag) {
    setElement(Document.get().createElement(tag));
  }

  @Override
  public void setWidget(final IsWidget w) {
    if (widget != null) {
      super.remove(widget);
    }
    widget = w;
    if (w != null) {
      super.add(w);
    }
  }

  public CustomHTMLPanel(final String tag, final String role) {
    setElement(Document.get().createElement(tag));
  }

  public void setTag(final String tag) {
    setElement(Document.get().createElement(tag));
  }

  public void setRole(final String role) {
    this.getElement().setAttribute("role", role);
  }

  @Override
  public void add(final Widget w) {
    add(w, getElement());
  }

  public String getHTML() {
    return getElement().getInnerHTML();
  }

  public String getText() {
    return getElement().getInnerText();
  }

  public void setHTML(final SafeHtml html) {
    getElement().setInnerSafeHtml(html);
  }

  public void setInnerText(final String text) {
    getElement().setInnerText(text);
  }

}
