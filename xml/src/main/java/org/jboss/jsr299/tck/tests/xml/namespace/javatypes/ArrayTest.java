/*
 * JBoss, Home of Professional Open Source
 * Copyright 2008, Red Hat Middleware LLC, and individual contributors
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

package org.jboss.jsr299.tck.tests.xml.namespace.javatypes;

import org.hibernate.tck.annotations.SpecAssertion;
import org.hibernate.tck.annotations.SpecAssertions;
import org.jboss.jsr299.tck.AbstractJSR299Test;
import org.jboss.testharness.impl.packaging.Artifact;
import org.jboss.testharness.impl.packaging.jsr299.BeansXml;
import org.testng.annotations.Test;

/**
 * Tests use of the &lt;Array&gt; element in XML.
 * 
 * @author David Allen
 *
 */
@Artifact
@BeansXml("array-beans.xml")
public class ArrayTest extends AbstractJSR299Test
{
   @Test(groups = { "broken", "xml" })
   @SpecAssertions({
      @SpecAssertion(section="9.2.1", id="d")
    })
    //TODO Cannot test array element since there is no defined place for it to appear
   public void testArrayElement()
   {
      //TODO Test is using array on constructor, but that is not injectable
      assert false;
   }
}
