package com.devbliss.gwt.commons.client.widget.panel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * 
 * @author <a href="mailto:jb@barop.de">Johannes Barop</a>
 * 
 */
public class ImageAnchorTestGwt extends GWTTestCase {

  interface Bundle extends ClientBundle {
    ImageResource devbliss();
  }

  @Override
  public String getModuleName() {
    return "com.devbliss.gwt.commons.Commons";
  }

  /**
   * Check if an {@link ImageAnchor} is properly created when referencing an image URI.
   */
  public void testUri() {
    ImageAnchor imageAnchor = new ImageAnchor("http://www.google.de",
        "https://www.google.de/images/srpr/logo3w.png");

    assertTrue("a".equalsIgnoreCase(imageAnchor.getElement().getTagName()));
    assertEquals("http://www.google.de", imageAnchor.getElement().getAttribute("href"));
    assertEquals(1, imageAnchor.getElement().getChildCount());
    assertTrue("img".equalsIgnoreCase(imageAnchor.getElement().getFirstChildElement().getTagName()));
    assertEquals("https://www.google.de/images/srpr/logo3w.png",
        imageAnchor.getElement().getFirstChildElement().getAttribute("src"));
  }

  /**
   * Check if an {@link ImageAnchor} is properly created when referencing an image resource.
   */
  public void testImageResource() {
    Bundle bundle = GWT.create(Bundle.class);
    ImageAnchor imageAnchor = new ImageAnchor("http://www.devbliss.com", bundle.devbliss());

    assertTrue("a".equalsIgnoreCase(imageAnchor.getElement().getTagName()));
    assertEquals("http://www.devbliss.com", imageAnchor.getElement().getAttribute("href"));
    assertEquals(1, imageAnchor.getElement().getChildCount());
    assertTrue("img".equalsIgnoreCase(imageAnchor.getElement().getFirstChildElement().getTagName()));
    assertEquals(bundle.devbliss().getWidth() + "px",
        imageAnchor.getElement().getFirstChildElement().getStyle().getWidth());
    assertEquals(bundle.devbliss().getHeight() + "px",
        imageAnchor.getElement().getFirstChildElement().getStyle().getHeight());
    // there is no smart way to retrieve the background property
    assertTrue(imageAnchor.toString().contains(bundle.devbliss().getSafeUri().asString()));
  }

}
