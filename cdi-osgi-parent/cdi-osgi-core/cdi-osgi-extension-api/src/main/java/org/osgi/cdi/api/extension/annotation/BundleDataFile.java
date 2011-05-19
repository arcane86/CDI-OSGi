package org.osgi.cdi.api.extension.annotation;


import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * <p>This annotation qualifies an injection point that represents a bundle data
 * file.</p>
 * <p>It allows to specify the relative path of the file in the bundle, as a
 * required value.</p>
 * <p>The file path is <b>not</b> actually qualifying the
 * injection point, thus this annotation is for global bundle data file injection
 * point with additional data. To discriminate the bundle use
 * {@link OSGiBundle} or {@link BundleName} and
 * {@link BundleVersion} annotations.</p>
 *
 * @author Mathieu ANCELIN - SERLI (mathieu.ancelin@serli.com)
 * @author Matthieu CLOCHARD - SERLI (matthieu.clochard@serli.com)
 * @see Qualifier
 * @see org.osgi.framework.Bundle
 * @see OSGiBundle
 * @see BundleName
 * @see BundleVersion
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface BundleDataFile {

    /**
     * The data file that should be injected. Nondiscriminatory value for the typesafe resolution algorithm.
     *
     * @return the relative path of the data file in the current bundle.
     */
    @Nonbinding String value();
}
