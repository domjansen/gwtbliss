package com.devbliss.gwt.commons.client.service;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.callback.CallbackFilter;

import com.google.gwt.http.client.Header;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;

/**
 * This {@link CallbackFilter} removes the unparsable cruft "<{(" from the incoming JSON if present.
 * 
 * <p>
 * The server may add such an unparsable cruft or "dont't be evil" part in front of the JSON
 * response in order that the string cannot be <code>eval()</code>'ed directly.
 * </p>
 * 
 * @author <a href="mailto:jb@barop.de">Johannes Barop</a>
 * 
 */
public class UnparsableCruftCallbackFilter implements CallbackFilter {

  /**
   * Wraps an existing {@link Response} and intercepts {@link Response#getText()} to remove the
   * unparsable cruft "<{(" when it's present.
   */
  static class UnparsableCruftResponse extends Response {

    /**
     * The original Response which may be crufted.
     */
    private final Response original;

    /**
     * Construct a new {@link UnparsableCruftResponse}.
     * 
     * @param original The original Response which may be crufted
     */
    public UnparsableCruftResponse(final Response original) {
      this.original = original;
    }

    @Override
    public String getText() {
      return original.getText().replaceFirst("^[ ]*<\\{\\(", "");
    }

    @Override
    public String getStatusText() {
      return original.getStatusText();
    }

    @Override
    public int getStatusCode() {
      return original.getStatusCode();
    }

    @Override
    public String getHeadersAsString() {
      return original.getHeadersAsString();
    }

    @Override
    public Header[] getHeaders() {
      return original.getHeaders();
    }

    @Override
    public String getHeader(final String header) {
      return original.getHeader(header);
    }

  }

  /**
   * Wraps an existing {@link RequestCallback} and intercepts
   * {@link RequestCallback#onResponseReceived(Request, Response)} to return a new {@link Response}.
   */
  static class CallbackWrapper implements RequestCallback {

    /**
     * The original {@link RequestCallback}.
     */
    private final RequestCallback originalCallback;

    /**
     * The new {@link Response} which should be returned by the {@link RequestCallback}.
     */
    private final Response newResponse;

    /**
     * Construct a new {@link CallbackWrapper}.
     * 
     * @param originalCallback The original {@link RequestCallback}
     * @param newResponse The new {@link Response} which should be returned by the
     *          {@link RequestCallback}.
     */
    public CallbackWrapper(final RequestCallback originalCallback, final Response newResponse) {
      this.originalCallback = originalCallback;
      this.newResponse = newResponse;
    }

    @Override
    public void onResponseReceived(final Request request, final Response response) {
      originalCallback.onResponseReceived(request, newResponse);
    }

    @Override
    public void onError(final Request request, final Throwable exception) {
      originalCallback.onError(request, exception);
    }

  }

  @Override
  public RequestCallback filter(final Method method, final Response originalResponse,
      final RequestCallback originalCallback) {
    return new CallbackWrapper(originalCallback, new UnparsableCruftResponse(originalResponse));
  }

}
