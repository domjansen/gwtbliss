/*
 * Copyright 2013, devbliss GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.devbliss.gwtbliss.client.ui;

import suites.GWTTestSuite;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 *
 * @author <a href="mailto:jb@barop.de">Johannes Barop</a>
 *
 */
public class ImageAnchorIntegrationGWTTest extends GWTTestCase {

  interface Bundle extends ClientBundle {
    ImageResource devbliss();
  }

  @Override
  public String getModuleName() {
    return GWTTestSuite.TEST_MODULE_NAME;
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
    assertEquals(bundle.devbliss().getWidth() + ".0px",
        imageAnchor.getElement().getFirstChildElement().getStyle().getWidth());
    assertEquals(bundle.devbliss().getHeight() + ".0px",
        imageAnchor.getElement().getFirstChildElement().getStyle().getHeight());
    // there is no smart way to retrieve the background property
    assertTrue(imageAnchor.toString().contains(bundle.devbliss().getSafeUri().asString()));
  }

}
