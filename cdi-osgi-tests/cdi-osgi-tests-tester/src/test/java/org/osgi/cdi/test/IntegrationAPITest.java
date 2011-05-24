package org.osgi.cdi.test;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.cdi.test.util.Environment;
import org.osgi.framework.BundleContext;

import static org.ops4j.pax.exam.CoreOptions.options;

@RunWith(JUnit4TestRunner.class)
public class IntegrationAPITest {

    @Configuration
    public static Option[] configure() {
        return options(
                Environment.CDIOSGiEnvironment(
//                        mavenBundle("org.osgi.cdi.test", "cdi-osgi-test-bundle1").version("0.2-SNAPSHOT")
                )
        );
    }

    @Test
    public void CDIContainerFactoryTest(BundleContext context) throws InterruptedException {
        Environment.waitForEnvironment(context);

        Assert.assertTrue(true);
    }
}
