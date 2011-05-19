package org.osgi.cdi.api.extension.events;

import org.osgi.framework.BundleContext;

/**
 * <p>This class wraps all the bundle container events as inner static classes.
 * There is one event class by <code>BundleContainerEventType</code>.</p>
 * <p>Each inner class allows to:<ul>
 * <li>
 * <p>Represent a specific bundle container event,</p>
 * </li>
 * <li>
 * <p>Retrieve the same information as
 * <code>AbstractBundleContainerEvent</code>.</p>
 * </li>
 * </ul></p>
 * <p>They may be used in <code>Observes</code> method in order to listen a specific
 * bundle container event.</p>
 *
 * @author Mathieu ANCELIN - SERLI (mathieu.ancelin@serli.com)
 * @author Matthieu CLOCHARD - SERLI (matthieu.clochard@serli.com)
 * @see AbstractBundleContainerEvent
 * @see org.osgi.framework.Bundle
 * @see BundleContext
 * @see BundleContainerEventType
 * @see javax.enterprise.event.Observes
 */
public class BundleContainerEvents {

    /**
     * Represents the bundle events for the {@link BundleContainerEventType#INITIALIZED} state.
     */
    public static class BundleContainerInitialized extends AbstractBundleContainerEvent {

        /**
         * Construct a new {@link BundleContainerInitialized} event.
         * @param context the firing {@link BundleContext}.
         */
        public BundleContainerInitialized(BundleContext context) {
            super(context);
        }

        @Override
        public BundleContainerEventType getType() {
            return BundleContainerEventType.INITIALIZED;
        }
    }

    /**
     * Represents the bundle events for the {@link BundleContainerEventType#SHUTDOWN} state.
     */
    public static class BundleContainerShutdown extends AbstractBundleContainerEvent {

        /**
         * Construct a new {@link BundleContainerShutdown} event.
         * @param context the firing {@link BundleContext}.
         */
        public BundleContainerShutdown(BundleContext context) {
            super(context);
        }

        @Override
        public BundleContainerEventType getType() {
            return BundleContainerEventType.SHUTDOWN;
        }
    }

}
