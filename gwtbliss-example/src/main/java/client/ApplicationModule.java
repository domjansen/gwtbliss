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

package client;

import client.grid.GridPresenter;
import client.grid.GridViewImpl;
import client.index.IndexPresenter;
import client.index.IndexViewImpl;
import client.notfound.NotFoundPresenter;
import client.notfound.NotFoundViewImpl;

import com.devbliss.gwtbliss.client.mvp.BlissDefaultModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

/**
 * GIN configuration of common components.
 *
 * @author <a href="mailto:jb@barop.de">Johannes Barop</a>
 */
public class ApplicationModule extends AbstractPresenterModule {

  @Override
  protected void configure() {
    install(new BlissDefaultModule(ApplicationPlaceTokens.INDEX, ApplicationPlaceTokens.NOT_FOUND));

    bindPresenter(GridPresenter.class, GridPresenter.View.class, GridViewImpl.class,
        GridPresenter.Proxy.class);
    bindPresenter(NotFoundPresenter.class, NotFoundPresenter.View.class, NotFoundViewImpl.class,
        NotFoundPresenter.Proxy.class);
    bindPresenter(IndexPresenter.class, IndexPresenter.View.class, IndexViewImpl.class,
        IndexPresenter.Proxy.class);
  }

}
