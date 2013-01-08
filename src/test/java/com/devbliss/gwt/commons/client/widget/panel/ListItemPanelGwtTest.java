package com.devbliss.gwt.commons.client.widget.panel;

import com.google.gwt.junit.client.GWTTestCase;

/**
 * 
 * @author <a href="mailto:jb@barop.de">Johannes Barop</a>
 * 
 */
public class ListItemPanelGwtTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "com.devbliss.gwt.commons.Commons";
  }

  /**
   * Check that an {@link ListItemPanel} properly created.
   */
  public void testConstruction() {
    ListItemPanel listItemPanel = new ListItemPanel();
    assertTrue("li".equalsIgnoreCase(listItemPanel.getElement().getTagName()));
    assertTrue("<li></li>".equalsIgnoreCase(listItemPanel.toString()));

    listItemPanel = new ListItemPanel("");
    assertTrue("li".equalsIgnoreCase(listItemPanel.getElement().getTagName()));
    assertTrue("<li></li>".equalsIgnoreCase(listItemPanel.toString()));

    listItemPanel = new ListItemPanel("<a></a>");
    assertTrue("li".equalsIgnoreCase(listItemPanel.getElement().getTagName()));
    assertTrue("<li><a></a></li>".equalsIgnoreCase(listItemPanel.toString()));
  }

}
