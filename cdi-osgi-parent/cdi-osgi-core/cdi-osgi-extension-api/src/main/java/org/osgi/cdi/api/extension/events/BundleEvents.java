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

import org.osgi.framework.Bundle;

/**
 *
 * @author Mathieu ANCELIN - SERLI (mathieu.ancelin@serli.com)
 */
public class BundleEvents {

    public static class BundleInstalled extends AbstractBundleEvent {

        public BundleInstalled(Bundle bundle) {
            super(bundle);
        }

        @Override
        public BundleEventType getType() {
            return BundleEventType.INSTALLED;
        }
    }

    public static class BundleLazyActivation extends AbstractBundleEvent {

        public BundleLazyActivation(Bundle bundle) {
            super(bundle);
        }

        @Override
        public BundleEventType getType() {
            return BundleEventType.LAZY_ACTIVATION;
        }
    }

    public static class BundleResolved extends AbstractBundleEvent {

        public BundleResolved(Bundle bundle) {
            super(bundle);
        }

        @Override
        public BundleEventType getType() {
            return BundleEventType.RESOLVED;
        }
    }

    public static class BundleStarted extends AbstractBundleEvent {

        public BundleStarted(Bundle bundle) {
            super(bundle);
        }

        @Override
        public BundleEventType getType() {
            return BundleEventType.STARTED;
        }
    }

    public static class BundleStarting extends AbstractBundleEvent {

        public BundleStarting(Bundle bundle) {
            super(bundle);
        }

        @Override
        public BundleEventType getType() {
            return BundleEventType.STARTING;
        }
    }

    public static class BundleStopped extends AbstractBundleEvent {

        public BundleStopped(Bundle bundle) {
            super(bundle);
        }

        @Override
        public BundleEventType getType() {
            return BundleEventType.STOPPED;
        }
    }

    public static class BundleStopping extends AbstractBundleEvent {

        public BundleStopping(Bundle bundle) {
            super(bundle);
        }

        @Override
        public BundleEventType getType() {
            return BundleEventType.STOPPING;
        }
    }

    public static class BundleUninstalled extends AbstractBundleEvent {

        public BundleUninstalled(Bundle bundle) {
            super(bundle);
        }

        @Override
        public BundleEventType getType() {
            return BundleEventType.UNINSTALLED;
        }
    }

    public static class BundleUnresolved extends AbstractBundleEvent {

        public BundleUnresolved(Bundle bundle) {
            super(bundle);
        }

        @Override
        public BundleEventType getType() {
            return BundleEventType.UNRESOLVED;
        }
    }

    public static class BundleUpdated extends AbstractBundleEvent {

        public BundleUpdated(Bundle bundle) {
            super(bundle);
        }

        @Override
        public BundleEventType getType() {
            return BundleEventType.UPDATED;
        }
    }
}
