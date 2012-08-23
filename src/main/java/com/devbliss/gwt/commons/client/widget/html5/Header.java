package com.devbliss.gwt.commons.client.widget.html5;

import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * A HTML5 Header Element
 *
 * @see <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/sections.html#the-header-element">W3C Spec Draft</a>
 *
 * @author christoph.ulrich@devbliss.com
 */
public class Header extends HTMLPanel {

    private static final String HTML_TAG = "header";

    /**
     * Create empty header element
     */
    public Header() {
        this("");
    }

    /**
     * Create header element with html content
     * 
     * @param html content that will be nested in element
     */
    public Header(final String html) {
        super(HTML_TAG, html);
    }
}
