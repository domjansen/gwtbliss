package com.devbliss.gwt.commons.client.widget.html5;

import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * A HTML5 Article Element
 *
 * @see <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/sections.html#the-article-element">W3C Spec Draft</a>
 *
 * @author christoph.ulrich@devbliss.com
 */
public class Article extends HTMLPanel {

    private static final String HTML_TAG = "article";

    /**
     * Create empty article element
     */
    public Article() {
        this("");
    }

    /**
     * Create article element with html content
     * 
     * @param html content that will be nested in element
     */
    public Article(final String html) {
        super(HTML_TAG, html);
    }
}
