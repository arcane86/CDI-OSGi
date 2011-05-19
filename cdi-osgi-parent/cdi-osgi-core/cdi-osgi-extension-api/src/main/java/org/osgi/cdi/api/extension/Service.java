/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.osgi.cdi.api.extension;

import javax.enterprise.inject.Instance;
import javax.enterprise.util.TypeLiteral;
import java.lang.annotation.Annotation;

/**
 * <p>This interface represents a service instance producer parametrized by the service to inject. It has the same
 * behavior than CDI {@link Instance} except that it represents only OSGi service beans.</p> <p>IT allows to:<ul>
 *     <li>
 * <p>Wrap a list of potential service implementations as an {@link Iterable} java object,</p> </li> <li> <p>Select a
 * subset of these service implementations filtered by {@link javax.inject.Qualifier}s or LDAP filters,
 * </p> </li> <li>
 * <p>Iterate through these service implementations,</p> </li> <li> <p>Obtain an instance of the first remaining
 * service
 * implementations,</p> </li> <li> <p>Obtain utility informations about the contained service implementations.</p>
 * </li>
 * </ul></p> <p>OSGi services should not be subtyped.</p>
 *
 * @author Mathieu ANCELIN - SERLI (mathieu.ancelin@serli.com)
 * @author Matthieu CLOCHARD - SERLI (matthieu.clochard@serli.com)
 * @see Instance
 * @see javax.enterprise.inject.spi.Producer
 */
public interface Service<T> extends Iterable<T> {

    T get();

    Service<T> select(Annotation... qualifiers);

    <U extends T> Service<U> select(Class<U> subtype, Annotation... qualifiers);

    <U extends T> Service<U> select(TypeLiteral<U> subtype, Annotation... qualifiers);

    boolean isUnsatisfied();

    boolean isAmbiguous();

    int size();
}
