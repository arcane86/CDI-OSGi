package org.osgi.cdi.api.extension.events;

import org.osgi.framework.BundleContext;

/**
 * Created by IntelliJ IDEA. User: matthieu Date: 17/05/11 Time: 09:39 To change this template use File | Settings |
 * File Templates.
 */
public class BundleContainerEvents {

    public static class BundleContainerInitialized extends AbstractBundleContainerEvent {

        public BundleContainerInitialized(BundleContext context) {
            super(context);
        }

        @Override
        public BundleContainerEventType getType() {
            return BundleContainerEventType.INITIALIZED;
        }
    }

    public static class BundleContainerShutdown extends AbstractBundleContainerEvent {

        public BundleContainerShutdown(BundleContext context) {
            super(context);
        }

        @Override
        public BundleContainerEventType getType() {
            return BundleContainerEventType.SHUTDOWN;
        }
    }

}
