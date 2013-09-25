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

package client.resources;

import client.resources.lang.ApplicationMessages;
import client.resources.css.*;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.StyleInjector;

/**
 * Wraps access to the resources and provides proper initialization.
 *
 * @author <a href="mailto:jb@barop.de">Johannes Barop</a>
 *
 */
public class ApplicationResources {

  private static ApplicationMessages lang;

  private static ApplicationResourceBundle bundle;

  /**
   * Ensure that needed styles are injected into the browser DOM.
   *
   * <p>
   * This is needed that styles like "html {}" work although the style is not yet used directly on
   * any widget. This is typically called when the application starts.
   * </p>
   */
  public void ensureInjected() {
    mayInitializeAndInjectBundle();
  }

  /**
   * @return Instance of i18n interface.
   */
  public ApplicationMessages lang() {
    return mayInitializeLang();
  }

  /**
   * @return Instance of common CSS interface.
   */
  public Common cssCommon() {
    Common commonStyles = mayInitializeAndInjectBundle().common();
    commonStyles.ensureInjected();

    return commonStyles;
  }

  /**
   * @return Injected instance of {@link ApplicationResourceBundle.ResponsiveCommonStyles}.
   */
  public ResponsiveDefault cssResp() {
    ResponsiveDefault styles = mayInitializeAndInjectBundle().responsiveDefault();
    styles.ensureInjected();

    return styles;
  }

  /**
   * Lazy initialization of i18n interface.
   */
  private static ApplicationMessages mayInitializeLang() {
    if (lang == null) {
      lang = GWT.create(ApplicationMessages.class);
    }

    return lang;
  }

  /**
   * Lazy initialization of client bundle.
   */
  private static ApplicationResourceBundle mayInitializeAndInjectBundle() {
    if (bundle == null) {
      bundle = GWT.create(ApplicationResourceBundle.class);
      bundle.common().ensureInjected();
      bundle.responsiveDefault().ensureInjected();

      /*
       * Inject the CSS media queries after all previously injected styles.
       *
       * This is done so that every style modified by a matching media query overrides its original
       * style.
       */
      StyleInjector.injectAtEnd(getMediaQueries());
    }

    return bundle;
  }

  /**
   * @return A CSS string representing the media queries.
   */
  private static String getMediaQueries() {
    String responsivePhonePortrait = "@media (orientation: portrait){"
        + bundle.responsivePhonePortraitCss().getText() + "}";
    String responsivePhoneLandscape = "@media (orientation: landscape) {"
        + bundle.responsivePhoneLandscapeCss().getText() + "}";
    String responsiveTabletPortrait = "@media (min-width: 600px) and  (orientation: portrait) {"
        + bundle.responsiveTabletPortraitCss().getText() + "}";
    String responsiveTabletLandscape = "@media (min-width: 800px) and (orientation: landscape) {"
        + bundle.responsiveTabletLandscapeCss().getText() + "}";
    String commonDesktop = "@media (min-width: 940px) {" + bundle.responsiveDefault().getText() + "}";

    return responsivePhonePortrait + " " + responsivePhoneLandscape + " " + responsiveTabletPortrait + " "
        + responsiveTabletLandscape + " " + commonDesktop;
  }

}
