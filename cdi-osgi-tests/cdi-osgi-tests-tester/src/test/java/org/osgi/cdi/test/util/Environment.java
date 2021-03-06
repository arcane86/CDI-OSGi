package org.osgi.cdi.test.util;

import org.ops4j.pax.exam.Option;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.ops4j.pax.exam.CoreOptions.*;
import static org.ops4j.pax.exam.LibraryOptions.junitBundles;

public class Environment {

    public static Option[] CDIOSGiEnvironment(Option... options) {
        List<Option> result = new ArrayList<Option>();
        result.add(mavenBundle("org.osgi.cdi", "cdi-osgi-mandatory").version("1.0-SNAPSHOT"));
        result.add(mavenBundle("org.osgi.cdi", "cdi-osgi-extension-api").version("1.0-SNAPSHOT"));
        result.add(mavenBundle("org.osgi.cdi", "cdi-osgi-integration-api").version("1.0-SNAPSHOT"));
        result.add(mavenBundle("org.jboss.weld.osgi", "weld-osgi-impl").version("1.0-SNAPSHOT"));
        result.add(mavenBundle("org.osgi.cdi", "cdi-osgi-extension-impl").version("1.0-SNAPSHOT"));
        result.add(junitBundles());
        result.add(felix());
        Collections.addAll(result, options);
        return result.toArray(new Option[result.size()]);
    }

    public static void waitForEnvironment(BundleContext context) throws InterruptedException {
        boolean ready = false;
        while(!ready) {
            ready = true;
            for(Bundle b : context.getBundles()) {
                if(b.getState() == Bundle.STARTING) {
                    ready = false;
                    break;
                }
                Thread.sleep(1000);
            }
        }
    }

    public static String state(BundleContext context) {
        String result = "", state;
        for(Bundle b : context.getBundles()) {
            switch(b.getState()) {
                case Bundle.ACTIVE:
                    state = "ACTIVE";
                    break;
                case Bundle.INSTALLED:
                    state = "INSTALLED";
                    break;
                case Bundle.RESOLVED:
                    state = "RESOLVED";
                    break;
                case Bundle.STARTING:
                    state = "STARTING";
                    break;
                case Bundle.STOPPING:
                    state = "STOPPING";
                    break;
                case Bundle.UNINSTALLED:
                    state = "UNINSTALLED";
                    break;
                default:
                    state = "UNKNOWN";
            }
            result += b.getSymbolicName() + "-" + b.getVersion() + ": " + state+System.getProperty("line.separator");
        }
        return result;
    }

}
