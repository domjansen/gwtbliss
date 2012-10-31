/**
 *
 */
package com.devbliss.gwt.commons.client.widget.panel;

import com.google.gwt.dom.client.Document;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public class CustomHTMLPanel extends ComplexPanel implements AcceptsOneWidget {

    /**
     *
     */
    private IsWidget widget = null;

    /**
     *
     */
    public CustomHTMLPanel() {
    }

    /**
     * 
     * @param tag
     */
    @UiConstructor
    public CustomHTMLPanel(String tag) {
        setElement(Document.get().createElement(tag));
    }

    /**
     *
     */
    @Override
    public void setWidget(IsWidget w) {
        if (widget != null)
            super.remove(widget);
        widget = w;
        if (w != null)
            super.add(w);
    }

    /**
     * 
     * @param tag
     * @param role
     */
    public CustomHTMLPanel(String tag, String role) {
        setElement(Document.get().createElement(tag));
    }

    /**
     * 
     * @param tag
     */
    public void setTag(String tag) {
        setElement(Document.get().createElement(tag));
    }

    /**
     * 
     * @param role
     */
    public void setRole(String role) {
        this.getElement().setAttribute("role", role);
    }

    /**
     * @param w
     */
    @Override
    public void add(Widget w) {
        add(w, getElement());
    }

    /**
     * 
     * @return String
     */
    public String getHTML() {
        return getElement().getInnerHTML();
    }

    /**
     * 
     * @return String
     */
    public String getText() {
        return getElement().getInnerText();
    }

    /**
     * 
     * @param html
     */
    public void setHTML(String html) {
        getElement().setInnerHTML(html);
    }

    /**
     * 
     * @param html
     */
    public void setHTML(SafeHtml html) {
        setHTML(html.asString());
    }

    /**
     * 
     * @param text
     */
    public void setInnerText(String text) {
        getElement().setInnerText(text);
    }

}
