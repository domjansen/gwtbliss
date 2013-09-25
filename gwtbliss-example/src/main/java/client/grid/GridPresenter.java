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

package client.grid;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

/**
 * Presenter which handles the rendering of the main grid which holds all other elemets.
 * 
 * @author <a href="mailto:jb@barop.de">Johannes Barop</a>
 * 
 */
public class GridPresenter extends Presenter<GridPresenter.View, GridPresenter.Proxy> {

    public interface View extends com.gwtplatform.mvp.client.View {
    }

    @ProxyStandard
    public interface Proxy extends com.gwtplatform.mvp.client.proxy.Proxy<GridPresenter> {
    }

    /**
     * Slot for the main-content-area.
     */
    @ContentSlot
    public static final Type<RevealContentHandler<?>> MAIN_SLOT = new Type<RevealContentHandler<?>>();

    @Inject
    public GridPresenter(final EventBus eventBus, final View view, final Proxy proxy) {
        super(eventBus, view, proxy);
    }

    @Override
    protected void revealInParent() {
        RevealRootContentEvent.fire(this, this);
    }

}
