package com.devbliss.gwt.commons.client.widget.html5;

import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * A HTML5 Section Element.
 * 
 * @see <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/sections.html#the-section-element">W3C Spec Draft</a>
 *
 * @author christoph.ulrich@devbliss.com
 */
public class Section extends HTMLPanel {

    private static final String HTML_TAG = "section";

    /**
     * Create empty section element
     */
    public Section() {
        this("");
    }

    /**
     * Create section element with html content
     * 
     * @param html content that will be nested in element
     */
    public Section(final String html) {
        super(HTML_TAG, html);
    }
}
