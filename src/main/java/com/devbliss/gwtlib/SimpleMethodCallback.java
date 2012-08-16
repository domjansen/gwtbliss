package com.devbliss.gwtlib;

import java.util.logging.Logger;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.logging.client.LogConfiguration;

/**
 * Aim: Avoids boilerplate code and replaces MethodCallback<T>
 * 
 * Actually, we do not want that service users must implement onFailure
 * Method. If a failure occurs it will be catched way before. By design.
 * 
 * Example usage: <code>
 * profileService.getProfile(new SimpleMethodCallback<ProfileDto>() {
 * 
 * @Override
 *           public void onSuccess(Method method, ProfileDto response) {
 *           setCurrentTab(response);
 *           }
 *           }); </code>
 * 
 *           OLD USAGE => WE NEEDED TO IMPLEMENT THE USELESS onFailure method... <code>
 * profileService.getProfile(new MethodCallback<ProfileDto>() {
 * 
 * @Override
 *           public void onSuccess(Method method, ProfileDto response) {
 *           setCurrentTab(response);
 *           }
 * 
 * @Override
 *           public void onFailure(Method method, Throwable exception) {
 *           Window.alert("failure getting dto => not logged in?");
 *           }
 *           });
 * 
 *           </code>
 * 
 * @author raphael@raphaelbauer.com
 * 
 * @param <T>
 */
public abstract class SimpleMethodCallback<T> implements MethodCallback<T> {

    /**
     * This method should be implemented by user of service.
     */
    public abstract void onSuccess(Method method, T response);

    /**
     * Must NOT be implemented by user of service.
     */
    public final void onFailure(final Method method, final Throwable exception) {
        if (LogConfiguration.loggingIsEnabled()) {
            Logger.getLogger(SimpleMethodCallback.class.getName()).severe(
                    "ERROR in " + this.getClass() + "#onFailure. This should not happen "
                            + "when using this callback type. " + exception.getMessage());
        }
    }
}
