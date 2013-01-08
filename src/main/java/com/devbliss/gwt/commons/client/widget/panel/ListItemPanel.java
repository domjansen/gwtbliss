package com.devbliss.gwt.commons.client.widget.panel;

import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * A panel for list item objects.
 * 
 * @author <a href="mailto:jb@barop.de">Johannes Barop</a>
 */
public class ListItemPanel extends HTMLPanel {

  public ListItemPanel() {
    this("");
  }

  public ListItemPanel(String html) {
    super("li", html);
  }

}
