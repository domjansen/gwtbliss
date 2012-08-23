package com.devbliss.gwt.commons.client.widget.html5;

import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * A HTML5 Hgroup Element
 *
 * @see <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/sections.html#the-hgroup-element">W3C Spec Draft</a>
 *
 * @author christoph.ulrich@devbliss.com
 */
public class Hgroup extends HTMLPanel {

    private static final String HTML_TAG = "hgroup";

    /**
     * Create empty section element
     */
    public Hgroup() {
        this("");
    }

    /**
     * Create hgroup element with html content
     * 
     * @param html content that will be nested in element
     */
    public Hgroup(final String html) {
        super(HTML_TAG, html);
    }
}
