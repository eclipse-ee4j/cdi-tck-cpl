/*
 * JBoss, Home of Professional Open Source
 * Copyright 2008, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
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
package org.jboss.jsr299.tck.spi;

import java.io.IOException;

/**
 * Provides Bean related operations.
 * 
 * The TCK porting package must provide an implementation of this interface which is 
 * suitable for the target implementation.
 * 
 * This interface may be removed.
 * 
 * @author Shane Bryzak
 * @author Pete Muir
 * @author David Allen
 * 
 */
public interface Beans
{

   public static final String PROPERTY_NAME = Beans.class.getName();
   
   /**
    * Determines if the object instance is actually a proxy object.
    * 
    * @param instance The object which might be a proxy
    * @return true if the object is a proxy
    */
   public boolean isProxy(Object instance);

   /**
    * Serializes the object tree starting with the bean instance provided.
    *
    * @param instance The bean instance to serialize
    * @return the serialized byte array of the bean instance
    */
   public byte[] serialize(Object instance) throws IOException;

   /**
    * Deserializes a bean instance from the given serialized bytes.
    *
    * @param bytes The serialized byte stream of a bean instance
    * @return the serialized byte array of the bean instance
    */
   public Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException;
   
}
