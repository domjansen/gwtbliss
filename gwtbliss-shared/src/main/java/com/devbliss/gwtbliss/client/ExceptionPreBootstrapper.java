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

package com.devbliss.gwtbliss.client;

import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.DialogBox;
import com.gwtplatform.mvp.client.PreBootstrapper;

/**
 * Add an uncaught exception handler which shows unhandled exceptions.
 *
 * @author <a href="mailto:jb@barop.de">Johannes Barop</a>
 *
 */
public class ExceptionPreBootstrapper implements PreBootstrapper {

  private static final Logger LOG = Logger.getLogger(ExceptionPreBootstrapper.class.getName());

  @Override
  public void onPreBootstrap() {
    GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
      @Override
      public void onUncaughtException(final Throwable e) {
        LOG.severe(getStacktrace(e));
        GWT.log("UncaughtException!", e);
        showExceptionPopup(e);
      }
    });
  }

  /**
   * @return The stacktrace to the given exception.
   */
  private String getStacktrace(final Throwable throwable) {
    String stacktrace = "";
    Throwable cur = throwable;

    while (cur != null) {
      final StackTraceElement[] stackTraceElements = cur.getStackTrace();
      stacktrace += cur.toString() + "\n";
      for (int i = 0; i < stackTraceElements.length; i++) {
        stacktrace += "    at " + stackTraceElements[i] + "\n";
      }
      cur = cur.getCause();
      if (cur != null) {
        stacktrace += "Caused by: ";
      }
    }

    return stacktrace;
  }

  /**
   * Shows the given exception to the user.
   */
  private void showExceptionPopup(final Throwable e) {
    final String output = getQuote() + getStacktrace(e);

    final DialogBox dialogBox = new DialogBox(true, false);
    DOM.setStyleAttribute(dialogBox.getElement(), "backgroundColor", "#ABCDEF");
    dialogBox.setHTML("<pre style='font-family: monospace; font-size: 0.8em; margin: 0; padding: 10px;'>"
        + output + "</pre>");
    dialogBox.center();
  }

  /**
   * @return A shocking quote which is shown in the HTML output.
   */
  private String getQuote() {
    String quote = "";

    quote += "[The crew waits quietly as a Reaver ship passes.] \n";
    quote += "Simon: What happens if they board us?  \n";
    quote += "Zoe:   If they take the ship, they'll rape us to death, eat our flesh, and sew our skins into their clothing. \n";
    quote += "       And if we're very, very lucky they'll do it in that order. \n\n";

    return quote;
  }

}
