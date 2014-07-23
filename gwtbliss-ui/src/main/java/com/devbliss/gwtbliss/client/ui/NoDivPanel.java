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

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;

import java.util.logging.Logger;

/**
 * check this class, clean up and write test
 */
public class NoDivPanel extends ComplexPanel {

  public NoDivPanel(final SafeHtml safeHtml) {
    setElement(createDocumentFragment());
    final String asString = safeHtml.asString();

    getElement().setInnerHTML(asString);

  }

  public NoDivPanel() {
    setElement(createDocumentFragment());
  }

  public NoDivPanel(final String tag, final String html) {
    /*
     * IE has very arbitrary rules about what will and will not accept innerHTML. <table> and
     * <tbody> simply won't, the property is read only. <p> will explode if you incorrectly try to
     * put another <p> inside of it. And who knows what else.
     *
     * However, if you cram a complete, possibly incorrect structure inside a div, IE will swallow
     * it gladly. So that's what we do here in the name of IE robustification.
     */
    final StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('<').append(tag).append('>').append(html);
    stringBuilder.append("</").append(tag).append('>');

    // We could use the static hiddenDiv, but that thing is attached
    // to the document. The caller might not want that.

    final DivElement scratchDiv = Document.get().createDivElement();
    scratchDiv.setInnerHTML(stringBuilder.toString());
    setElement(createDocumentFragment());
    getElement().removeFromParent();
  }

  native Element createDocumentFragment()/*-{
                                         var d = document.createDocumentFragment();
                                         return d;
                                         }-*/;

  @Override
  public void add(final Widget widget) {
    getChildren().add(widget);
    DOM.appendChild(getElement(), widget.getElement());
  }

  @Override
  public void add(final Widget widget, final Element elem) {
    final com.google.gwt.user.client.Element clientElem = elem.cast();
    super.add(widget, clientElem);
  }

}
