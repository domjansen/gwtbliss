package com.devbliss.gwt.commons.client.service;

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

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;

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
