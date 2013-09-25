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

package client.notfound;

import client.ApplicationPlaceTokens;
import client.grid.GridPresenter;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

/**
 * Presenter which displays the 404 (NotFound) page.
 * 
 * @author <a href="mailto:jb@barop.de">Johannes Barop</a>
 * 
 */
public class NotFoundPresenter extends Presenter<NotFoundPresenter.View, NotFoundPresenter.Proxy> {

    public interface View extends com.gwtplatform.mvp.client.View {
    }

    @ProxyStandard
    @NameToken(ApplicationPlaceTokens.NOT_FOUND)
    public interface Proxy extends ProxyPlace<NotFoundPresenter> {
    }

    @Inject
    public NotFoundPresenter(final EventBus eventBus, final View view, final Proxy proxy) {
        super(eventBus, view, proxy);
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, GridPresenter.MAIN_SLOT, this);
    }

}
