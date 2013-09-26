/*
 * Copyright 2013, devbliss GmbH
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package client.resources;

import com.google.gwt.resources.client.ClientBundle;
import client.resources.css.*;

/**
 * The application's embedded resources.
 * 
 * @author <a href="mailto:jb@barop.de">Johannes Barop</a>
 * 
 */
interface ApplicationResourceBundle extends ClientBundle {

    /**
     * @return CSS Styles
     */
    @Source({
        "css/Common.css"
    })
    Common common();

    /**
     * @return Responsive CSS styles
     */
    @Source("css/ResponsiveDefault.css")
    ResponsiveDefault responsiveDefault();

    /**
     * @return CSS definitions for tablet-like views in portrait mode.
     */
    @Source("css/ResponsiveTabletPortrait.css")
    ResponsiveDefault responsiveTabletPortraitCss();

    /**
     * @return CSS definitions for tablet-like views in landscape mode.
     */
    @Source("css/ResponsiveTabletLandscape.css")
    ResponsiveDefault responsiveTabletLandscapeCss();

    /**
     * @return CSS definitions for phone-like views in portrait mode.
     */
    @Source("css/ResponsivePhonePortrait.css")
    ResponsiveDefault responsivePhonePortraitCss();

    /**
     * @return CSS definitions for phone-like views in landscape mode.
     */
    @Source("css/ResponsivePhoneLandscape.css")
    ResponsiveDefault responsivePhoneLandscapeCss();

}
