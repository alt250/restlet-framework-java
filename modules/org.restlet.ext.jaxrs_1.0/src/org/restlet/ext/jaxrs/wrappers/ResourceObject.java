/*
 * Copyright 2005-2008 Noelios Consulting.
 * 
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License (the "License"). You may not use this file except in
 * compliance with the License.
 * 
 * You can obtain a copy of the license at
 * http://www.opensource.org/licenses/cddl1.txt See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * When distributing Covered Code, include this CDDL HEADER in each file and
 * include the License file at http://www.opensource.org/licenses/cddl1.txt If
 * applicable, add the following below this CDDL HEADER, with the fields
 * enclosed by brackets "[]" replaced with your own identifying information:
 * Portions Copyright [yyyy] [name of copyright owner]
 */

package org.restlet.ext.jaxrs.wrappers;

import java.lang.reflect.InvocationTargetException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ws.rs.WebApplicationException;

import org.restlet.ext.jaxrs.core.CallContext;
import org.restlet.ext.jaxrs.exceptions.InjectException;
import org.restlet.ext.jaxrs.exceptions.ConvertParameterException;
import org.restlet.ext.jaxrs.exceptions.MethodInvokeException;

/**
 * Represents a resource Object
 * 
 * @author Stephan
 * 
 */
public class ResourceObject {
    private ResourceClass resourceClass;

    private Object jaxRsResourceObject;

    /**
     * Creates a new wrapper for a resource object
     * 
     * @param jaxRsResourceObject
     *                the resource object
     * @param resourceClass
     *                the wrapped resource class
     * @param logger
     *                The logger to log unexpected Exceptions.
     */
    ResourceObject(Object jaxRsResourceObject, ResourceClass resourceClass) {
        if (jaxRsResourceObject == null)
            throw new IllegalArgumentException(
                    "The JAX-RS resource object must not be null");
        if (resourceClass == null)
            throw new IllegalArgumentException(
                    "The ResourceClass must not be null");
        if (jaxRsResourceObject instanceof ResourceObject)
            throw new IllegalArgumentException(
                    "The given resource class object should not be an instance of the wrapping class ResourceObject");
        this.jaxRsResourceObject = jaxRsResourceObject;
        this.resourceClass = resourceClass;
    }

    /**
     * @return Returns the wrapped resource class. Returns never null.
     */
    public ResourceClass getResourceClass() {
        return resourceClass;
    }

    /**
     * @return Returns the wrapped JAX-RS resource object. Returns never null.
     */
    Object getJaxRsResourceObject() {
        return jaxRsResourceObject;
    }

    /**
     * Initiates the resource object:
     * <ul>
     * <li>Injects all the supported dependencies into the this resource
     * object.</li>
     * <li> calls the method annotated with &#64;{@link PostConstruct}, see
     * JSR-250.</li>
     * </ul>
     * 
     * @param callContext
     *                The CallContext to get the dependencies from.
     * @throws InjectException
     *                 if the injection was not possible. See
     *                 {@link InjectException#getCause()} for the reason.
     * @throws WebApplicationException
     * @throws ConvertParameterException
     * @throws MethodInvokeException
     *                 if the method annotated with &#64;{@link PostConstruct}
     *                 could not be called or throws an exception.
     */
    public void init(CallContext callContext) throws InjectException,
            ConvertParameterException, MethodInvokeException {
        this.getResourceClass().init(this, callContext);
    }

    /**
     * Do work before destroying the object:
     * <ul>
     * <li>Calls the method annotated with &#64;{@link PreDestroy}, see
     * JSR-250.</li>
     * </ul>
     * 
     * @throws MethodInvokeException
     *                 if the method annotated with &#64;{@link PreDestroy}
     *                 could not be called
     * @throws InvocationTargetException
     * @throws InvocationTargetException
     *                 if the method annotated with &#64;{@link PreDestroy} has
     *                 thrown an Exception.
     */
    public void preDestroy() throws MethodInvokeException,
            InvocationTargetException {
        this.getResourceClass().preDestroy(this);
    }
}