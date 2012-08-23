package com.devbliss.gwt.commons.client.widget.html5;

import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * A HTML5 Footer Element
 *
 * @see <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/sections.html#the-footer-element">W3C Spec Draft</a>
 *
 * @author christoph.ulrich@devbliss.com
 */
public class Footer extends HTMLPanel {

    private static final String HTML_TAG = "footer";

    /**
     * Create empty footer element
     */
    public Footer() {
        this("");
    }

    /**
     * Create footer element with html content
     * 
     * @param html content that will be nested in element
     */
    public Footer(final String html) {
        super(HTML_TAG, html);
    }
}
