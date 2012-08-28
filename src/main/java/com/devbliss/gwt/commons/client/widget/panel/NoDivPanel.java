package com.devbliss.gwt.commons.client.widget.panel;

import java.util.logging.Logger;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;

public class NoDivPanel extends ComplexPanel {

    public NoDivPanel(SafeHtml safeHtml) {
        setElement(createDocumentFragment());
        final String asString = safeHtml.asString();

        getElement().setInnerHTML(asString);
        Logger.getLogger("nodiv").info(asString);

    }

    public NoDivPanel() {
        setElement(createDocumentFragment());
        Logger.getLogger("nodiv").info("empty");
    }

    public NoDivPanel(String tag, String html) {
        Logger.getLogger("nodiv").info(html);
        /*
         * IE has very arbitrary rules about what will and will not accept
         * innerHTML. <table> and <tbody> simply won't, the property is read only.
         * <p> will explode if you incorrectly try to put another <p> inside of it.
         * And who knows what else.
         *
         * However, if you cram a complete, possibly incorrect structure inside a
         * div, IE will swallow it gladly. So that's what we do here in the name of
         * IE robustification.
         */
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('<').append(tag).append('>').append(html);
        stringBuilder.append("</").append(tag).append('>');

        // We could use the static hiddenDiv, but that thing is attached
        // to the document. The caller might not want that.

        DivElement scratchDiv = Document.get().createDivElement();
        scratchDiv.setInnerHTML(stringBuilder.toString());
        setElement(createDocumentFragment());
        getElement().removeFromParent();
      }

    native Element createDocumentFragment()/*-{
        var d = document.createDocumentFragment();
        return d;
    }-*/;

    public void add(Widget widget){
        getChildren().add(widget);
        DOM.appendChild(getElement(), widget.getElement());
        Logger.getLogger("nodiv").info("add");
    }

    public void add(Widget widget, Element elem) {
        com.google.gwt.user.client.Element clientElem = elem.cast();
        super.add(widget, clientElem);
        Logger.getLogger("nodiv").info("add");
      }

}
