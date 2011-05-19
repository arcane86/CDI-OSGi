package org.osgi.cdi.api.extension.events;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * Created by IntelliJ IDEA. User: matthieu Date: 17/05/11 Time: 09:33 To change this template use File | Settings |
 * File Templates.
 */
public class ServiceEvents {

    public static class ServiceArrival extends AbstractServiceEvent {

        public ServiceArrival(
                ServiceReference ref, BundleContext context) {
            super(ref, context);
        }

        @Override
        public ServiceEventType eventType() {
            return ServiceEventType.SERVICE_ARRIVAL;
        }
    }

    public static class ServiceChanged extends AbstractServiceEvent {

        public ServiceChanged(
                ServiceReference ref, BundleContext context) {
            super(ref, context);
        }

        @Override
        public ServiceEventType eventType() {
            return ServiceEventType.SERVICE_CHANGED;
        }
    }

    public static class ServiceDeparture extends AbstractServiceEvent {

        public ServiceDeparture(
                ServiceReference ref, BundleContext context) {
            super(ref, context);
        }

        @Override
        public ServiceEventType eventType() {
            return ServiceEventType.SERVICE_DEPARTURE;
        }
    }

}
