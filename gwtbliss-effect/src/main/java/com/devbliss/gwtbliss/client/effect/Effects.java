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

package com.devbliss.gwtbliss.client.effect;

import static com.google.gwt.query.client.GQuery.$;

import com.google.gwt.user.client.ui.Widget;

/**
 * A generic effect class which proxies gQuery.
 */
public final class Effects {

  /**
   * Simple effects for gQuery.
   */
  public enum Effect {
    /**
     * Fades an element out in 500 millis.
     */
    FADE_OUT(500),
    /**
     * Fades an element in in 500 millis.
     */
    FADE_IN(500);

    /**
     * The default time frame for the effect.
     */
    int duration;

    private Effect(final int duration) {
      this.duration = duration;
    }

    /**
     * @return the duration
     */
    public int getDuration() {
      return duration;
    }

  }

  /**
   * Avoid instances.
   */
  private Effects() {
  }

  /**
   * Applies the specified effect to the referenced element.
   */
  public static void applyEffect(final Widget element, final Effect effect, final int... durations) {
    int duration = effect.getDuration();

    if (durations != null && durations.length == 0) {
      duration = durations[0];
    }

    switch (effect) {
      case FADE_IN:
        $(element).fadeIn(duration);
        break;
      case FADE_OUT:
        $(element).fadeOut(duration);
        break;
      default:
        break;
    }
  }

}
