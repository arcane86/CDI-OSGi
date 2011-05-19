package org.osgi.cdi.api.extension.events;

/**
 * <p>This enumeration list all possible states of a bundle container and the corresponding event types.</p>
 *
 * @author Mathieu ANCELIN - SERLI (mathieu.ancelin@serli.com)
 * @author Matthieu CLOCHARD - SERLI (matthieu.clochard@serli.com)
 * @see AbstractBundleContainerEvent
 * @see BundleContainerEvents
 */
public enum BundleContainerEventType {
    INITIALIZED,
    SHUTDOWN
}
