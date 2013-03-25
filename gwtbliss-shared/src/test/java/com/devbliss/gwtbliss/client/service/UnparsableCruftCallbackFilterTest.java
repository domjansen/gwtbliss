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

package com.devbliss.gwtbliss.client.service;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;

import com.devbliss.gwtbliss.client.service.UnparsableCruftCallbackFilter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.fusesource.restygwt.client.Method;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author <a href="mailto:jb@barop.de">Johannes Barop</a>
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class UnparsableCruftCallbackFilterTest {

  private static final String TEXT = "roflcopter";

  private UnparsableCruftCallbackFilter callbackFilter;

  @Mock
  private Method method;

  @Mock
  private Request request;
  @Mock
  private Response originalResponse;
  @Captor
  private ArgumentCaptor<Response> interceptedResponseCaptor;

  @Mock
  private RequestCallback originalCallback;

  @Before
  public void setUp() {
    callbackFilter = new UnparsableCruftCallbackFilter();
  }

  /**
   * Check that {@link Response#getText()} is not modified when the original string is not crufted.
   */
  @Test
  public void testWithUncruftedString() {
    when(originalResponse.getText()).thenReturn(TEXT);
    RequestCallback returnedCallback = callbackFilter.filter(method, originalResponse, originalCallback);
    returnedCallback.onResponseReceived(request, originalResponse);

    verify(originalCallback).onResponseReceived(eq(request), interceptedResponseCaptor.capture());

    assertEquals(TEXT, interceptedResponseCaptor.getValue().getText());
  }

  /**
   * Check that the unparsable cruft is removed from {@link Response#getText()} when the original
   * string is crufted.
   */
  @Test
  public void testWithCruftedString() {
    when(originalResponse.getText()).thenReturn("<{(" + TEXT);
    RequestCallback returnedCallback = callbackFilter.filter(method, originalResponse, originalCallback);
    returnedCallback.onResponseReceived(request, originalResponse);

    verify(originalCallback).onResponseReceived(eq(request), interceptedResponseCaptor.capture());

    assertEquals(TEXT, interceptedResponseCaptor.getValue().getText());
  }

}
