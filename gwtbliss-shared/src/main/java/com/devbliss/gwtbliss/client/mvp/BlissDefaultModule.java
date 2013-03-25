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

package com.devbliss.gwtbliss.client.mvp;

import org.fusesource.restygwt.client.Dispatcher;

import com.devbliss.gwtbliss.client.service.BlissRestyDispatcher;
import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.annotations.ErrorPlace;
import com.gwtplatform.mvp.client.annotations.UnauthorizedPlace;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.gwtplatform.mvp.client.proxy.DefaultPlaceManager;
import com.gwtplatform.mvp.client.proxy.RouteTokenFormatter;

/**
 * Special version of {@link DefaultModule} which uses {@link DefaultPlaceManager} and binds it's
 *
 * @author <a href="mailto:jb@barop.de">Johannes Barop</a>
 *
 */
public class BlissDefaultModule extends DefaultModule {

  private final String defaultPlaceToken;

  private final String notFoundToken;

  private final String unauthorizedToken;

  public BlissDefaultModule(
      final String defaultPlaceToken,
      final String notFoundToken,
      final String unauthorizedToken) {
    super(DefaultPlaceManager.class, RouteTokenFormatter.class);
    this.defaultPlaceToken = defaultPlaceToken;
    this.notFoundToken = notFoundToken;
    this.unauthorizedToken = unauthorizedToken;
  }

  public BlissDefaultModule(final String defaultPlaceToken, final String notFoundToken) {
    this(defaultPlaceToken, notFoundToken, defaultPlaceToken);
  }

  public BlissDefaultModule(final String defaultPlaceToken) {
    this(defaultPlaceToken, defaultPlaceToken);
  }

  @Override
  protected void configure() {
    super.configure();

    bindConstant().annotatedWith(DefaultPlace.class).to(defaultPlaceToken);
    bindConstant().annotatedWith(ErrorPlace.class).to(notFoundToken);
    bindConstant().annotatedWith(UnauthorizedPlace.class).to(unauthorizedToken);
    bind(Dispatcher.class).toProvider(BlissRestyDispatcher.Provider.class).asEagerSingleton();
  }

}
