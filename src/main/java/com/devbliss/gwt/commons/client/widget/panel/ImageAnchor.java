package com.devbliss.gwt.commons.client.widget.panel;

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
    ImageElement img = Document.get().createImageElement();
    img.setSrc(src);
    return img;
  }

  /**
   * Create an image element using an {@link ImageResource}.
   */
  private static ImageElement createImage(final ImageResource imageResource) {
    ImageElement img = new Image(imageResource).getElement().cast();
    return img;
  }

}
