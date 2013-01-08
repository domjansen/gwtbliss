package com.devbliss.gwt.commons.client.widget.panel;

import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.WidgetCollection;

/**
 * Panel for HTML lists.
 * 
 * <p>
 * Basically creates an UL tag and can contain other child LI widgets.
 * </p>
 * 
 * @author <a href="mailto:jb@barop.de">Johannes Barop</a>
 * 
 */
public class ListPanel extends HTMLPanel implements InsertPanel {

  public ListPanel() {
    this("");
  }
  
  public ListPanel(String html) {
    super("ul", html);
  }

  public WidgetCollection getChildren() {
    return super.getChildren();
  }

  @Override
  public void insert(final Widget w, final int beforeIndex) {
    insert(w, getElement(), beforeIndex, true);
  }
}
