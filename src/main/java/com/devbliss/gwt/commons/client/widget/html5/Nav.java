package com.devbliss.gwt.commons.client.widget.html5;

import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * A HTML5 Nav Element
 *
 * @see <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/sections.html#the-nav-element">W3C Spec Draft</a>
 *
 * @author christoph.ulrich@devbliss.com
 */

public class Nav extends HTMLPanel {
    private static final String HTML_TAG = "nav";

    /**
     * Create empty nav element
     */
    public Nav() {
        this("");
    }

    /**
     * Create nav element with html content
     * 
     * @param html
     */
    public Nav(final String html) {
        super(HTML_TAG, html);
    }
}
