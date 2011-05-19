/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.osgi.cdi.api.extension.events;

import javax.inject.Provider;

/**
 *
 * @author Mathieu ANCELIN - SERLI (mathieu.ancelin@serli.com)
 */
public class InterBundleEvent {

    private final Object event;

    private boolean sent = false;

    private Class<?> type;

    public InterBundleEvent(Object event) {
        this.event = event;
    }

    public InterBundleEvent(Object event, Class<?> type) {
        this.event = event;
        this.type = type;
    }

    public Class<?> type() {
        if (type != null) {
            return type;
        } else {
            return event.getClass();
        }
    }

    public boolean isTyped(Class<?> type) {
        if (this.type != null) {
            return this.type.equals(type);
        } else {
            return type.isAssignableFrom(event.getClass());
        }
    }

    public <T> Provider<T> typed(Class<T> type) {
        if (isTyped(type)) {
            return new Provider<T>() {
                @Override
                public T get() {
                    return (T) event;
                }
            };
        } else {
            throw new RuntimeException("The event is not of type " + type.getName());
        }
    }

    public Object get() {
        return event;
    }

    public boolean isSent() {
        return sent;
    }

    public void sent() {
        this.sent = true;
    }
}
