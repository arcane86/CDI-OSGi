package org.osgi.cdi.api.extension.events;

/**
 * <p>This enumeration lists all possible states of a service and the corresponding event types.</p>
 *
 * @author Mathieu ANCELIN - SERLI (mathieu.ancelin@serli.com)
 * @author Matthieu CLOCHARD - SERLI (matthieu.clochard@serli.com)
 * @see AbstractServiceEvent
 * @see ServiceEvents
 */
public enum ServiceEventType {

    SERVICE_ARRIVAL,
    SERVICE_DEPARTURE,
    SERVICE_CHANGED
}
