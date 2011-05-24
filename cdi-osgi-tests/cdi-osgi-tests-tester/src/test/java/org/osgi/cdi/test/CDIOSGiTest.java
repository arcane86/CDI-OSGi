package org.osgi.cdi.test;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.cdi.api.integration.CDIContainer;
import org.osgi.cdi.api.integration.CDIContainerFactory;
import org.osgi.cdi.test.util.Environment;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;

import static org.ops4j.pax.exam.CoreOptions.options;

@RunWith(JUnit4TestRunner.class)
public class CDIOSGiTest {

    @Configuration
    public static Option[] configure() {
        return options(
                Environment.CDIOSGiEnvironment()
        );
    }

    @Test
    public void launchTest(BundleContext context) throws InterruptedException, BundleException {
        Environment.waitForEnvironment(context);
        Bundle extAPI = null, intAPI = null, extImpl = null, intImpl = null;
        for(Bundle b : context.getBundles()) {
            if(b.getSymbolicName().equals("org.osgi.cdi.osgi-extension-api")) {
                extAPI=b;
            } else if(b.getSymbolicName().equals("org.osgi.cdi.osgi-integration-api")) {
                intAPI=b;
            } else if(b.getSymbolicName().equals("org.osgi.cdi.osgi-extension-impl")) {
                extImpl=b;
            } else if(b.getSymbolicName().equals("org.jboss.weld.osgi.weld-osgi-impl")) {
                intImpl=b;
            }
        }
        Assert.assertNotNull("Extension API bundle is not present",extAPI);
        Assert.assertNotNull("Integration API bundle is not present",intAPI);
        Assert.assertNotNull("Extension Impl bundle is not present",extImpl);
        Assert.assertNotNull("Integration Impl bundle is not present",intImpl);

        Assert.assertEquals("Extension API bundle is not ACTIVE",Bundle.ACTIVE,extAPI.getState());
        Assert.assertEquals("Integration API bundle is not ACTIVE",Bundle.ACTIVE,intAPI.getState());
        Assert.assertEquals("Extension Impl bundle is not ACTIVE",Bundle.ACTIVE,extImpl.getState());
        Assert.assertEquals("Integration Impl bundle is not ACTIVE",Bundle.ACTIVE,intImpl.getState());

        ServiceReference factoryReference = context.getServiceReference(CDIContainerFactory.class.getName());
        Assert.assertNotNull("CDI container factory service is not available",factoryReference);
        CDIContainerFactory factory = (CDIContainerFactory) context.getService(factoryReference);
        Assert.assertNotNull("CDI container factory is not available",factory);
        CDIContainer container = factory.containers();
        Assert.assertNotNull("CDI container is not produced",container);
        Assert.assertEquals("Some unnecessary CDI container are present",0,container.size());
    }
}
