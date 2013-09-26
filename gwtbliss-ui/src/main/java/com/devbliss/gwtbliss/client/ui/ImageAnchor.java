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

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Image;

/**
 * Anchor with an embedded image.
 *
 * @author <a href="mailto:jb@barop.de">Johannes Barop</a>
 *
 */
public class ImageAnchor extends Anchor {

  /**
   * Construct a {@link ImageAnchor} based on an image element.
   *
   * @param anchorHref The anchor's HREF (the URL to which the anchor links)
   * @param image Element of the image which is to display as anchor
   */
  public ImageAnchor(final String anchorHref, final ImageElement image) {
    getElement().appendChild(image);
    if (anchorHref != null) {
      setHref(anchorHref);
    }
  }

  /**
   * Construct a {@link ImageAnchor} based on an image URI.
   *
   * @param anchorHref The anchor's HREF (the URL to which the anchor links)
   * @param image URI referencing the image
   */
  public ImageAnchor(final String anchorHref, final String image) {
    this(anchorHref, createImage(image));
  }

  /**
   * Construct a {@link ImageAnchor} based on an image resource.
   *
   * @param anchorHref The anchor's HREF (the URL to which the anchor links)
   * @param image {@link ImageResource} referencing the image
   */
  public ImageAnchor(final String anchorHref, final ImageResource image) {
    this(anchorHref, createImage(image));
  }

  /**
   * Create an image element using an URI.
   */
  private static ImageElement createImage(final String src) {
    final ImageElement img = Document.get().createImageElement();
    img.setSrc(src);
    return img;
  }

  /**
   * Create an image element using an {@link ImageResource}.
   */
  private static ImageElement createImage(final ImageResource imageResource) {
    final ImageElement img = new Image(imageResource).getElement().cast();
    return img;
  }

}
