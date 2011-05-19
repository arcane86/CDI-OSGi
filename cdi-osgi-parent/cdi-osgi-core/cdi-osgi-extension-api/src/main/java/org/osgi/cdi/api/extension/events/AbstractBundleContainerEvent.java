package org.osgi.cdi.api.extension.events;

import org.osgi.framework.BundleContext;

/**
 * <p>This abstract class represents all the CDI-OSGi bundle container events as a
 * superclass.</p>
 * <p>It allows to:<ul>
 * <li>
 * <p>Represent all bundle container events,</p>
 * </li>
 * <li>
 * <p>Retrieve the current event type as a
 * {@link BundleContainerEventType},</p>
 * </li>
 * <li>
 * <p>Retrieve the firing {@link BundleContext}.</p>
 * </li>
 * </ul></p>
 * <p>It may be used in {@link javax.enterprise.event.Observes} method in order to listen all bundle
 * container events.</p>
 *
 * @author Mathieu ANCELIN - SERLI (mathieu.ancelin@serli.com)
 * @author Matthieu CLOCHARD - SERLI (matthieu.clochard@serli.com)
 * @see org.osgi.framework.Bundle
 * @see BundleContext
 * @see BundleContainerEvents
 * @see BundleContainerEventType
 * @see javax.enterprise.event.Observes
 */
public abstract class AbstractBundleContainerEvent {

    private BundleContext bundleContext;

    /**
     * Construct a new bundle container event for the current bundle.
     *
     * @param context the firing bundle context (current bundle context).
     */
    public AbstractBundleContainerEvent(final BundleContext context) {
        this.bundleContext = context;
    }

    /**
     * Get the firing bundle context.
     *
     * @return the firing {@link org.osgi.framework.BundleContext}.
     */
    public BundleContext getBundleContext() {
        return bundleContext;
    }

    /**
     * Get the bundle container event type.
     *
     * @return the {@link BundleContainerEventType} of the fired bundle container event.
     */
    public abstract BundleContainerEventType getType();

}
