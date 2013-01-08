package com.devbliss.gwt.commons.client.widget.panel;

import com.google.gwt.junit.client.GWTTestCase;

/**
 * 
 * @author <a href="mailto:jb@barop.de">Johannes Barop</a>
 * 
 */
public class ListPanelGwtTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "com.devbliss.gwt.commons.Commons";
  }

  /**
   * Check that an {@link ListItemPanel} properly created.
   */
  public void testConstruction() {
    ListPanel listPanel = new ListPanel();
    assertTrue("ul".equalsIgnoreCase(listPanel.getElement().getTagName()));
    assertTrue("<ul></ul>".equalsIgnoreCase(listPanel.toString()));

    listPanel = new ListPanel("");
    assertTrue("ul".equalsIgnoreCase(listPanel.getElement().getTagName()));
    assertTrue("<ul></ul>".equalsIgnoreCase(listPanel.toString()));

    listPanel = new ListPanel("<li>phew</li>");
    assertTrue("ul".equalsIgnoreCase(listPanel.getElement().getTagName()));
    assertTrue("<ul><li>phew</li></ul>".equalsIgnoreCase(listPanel.toString()));
  }

}
