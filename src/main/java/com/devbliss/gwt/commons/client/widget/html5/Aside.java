package com.devbliss.gwt.commons.client.widget.html5;

import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * A HTML5 Aside Element
 *
 * @see <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/sections.html#the-aside-element">W3C Spec Draft</a>
 *
 * @author christoph.ulrich@devbliss.com
 */
public class Aside extends HTMLPanel {

    private static final String HTML_TAG = "aside";

    /**
     * Create empty aside element
     */
    public Aside() {
        this("");
    }

    /**
     * Create aside element with html content
     * 
     * @param html content that will be nested in element
     */
    public Aside(final String html) {
        super(HTML_TAG, html);
    }
}
