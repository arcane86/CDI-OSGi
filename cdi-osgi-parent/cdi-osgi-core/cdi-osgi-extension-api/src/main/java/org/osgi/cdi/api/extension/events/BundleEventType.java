package org.osgi.cdi.api.extension.events;

/**
 * <p>This enumeration lists all possible states of a bundle and the corresponding event types.</p>
 *
 * @author Mathieu ANCELIN - SERLI (mathieu.ancelin@serli.com)
 * @author Matthieu CLOCHARD - SERLI (matthieu.clochard@serli.com)
 * @see AbstractBundleEvent
 * @see BundleEvents
 */
public enum BundleEventType {

    INSTALLED,
    LAZY_ACTIVATION,
    RESOLVED,
    STARTED,
    STARTING,
    STOPPED,
    STOPPING,
    UNINSTALLED,
    UNRESOLVED,
    UPDATED,
}
