/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat, Inc., and individual contributors
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

package org.jboss.jsr299.tck.tests.extensions.observer;

import org.jboss.jsr299.tck.AbstractJSR299Test;
import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.jboss.testharness.impl.packaging.Artifact;
import org.jboss.testharness.impl.packaging.IntegrationTest;
import org.jboss.testharness.impl.packaging.Resource;
import org.jboss.testharness.impl.packaging.Resources;
import org.testng.annotations.Test;

/**
 * Tests for the extensions provided by the ProcessObserverMethod events.
 * 
 * @author David Allen
 *
 */
@Artifact
@Resources({
   @Resource(source="javax.enterprise.inject.spi.Extension", destination="WEB-INF/classes/META-INF/services/javax.enterprise.inject.spi.Extension")
})
@IntegrationTest
@SpecVersion(spec="cdi", version="20091101")
public class ProcessObserverMethodEventTest extends AbstractJSR299Test
{
   @Test
   @SpecAssertion(section = "11.5.9", id = "aaa")
   public void testProcessObserverMethodEventsSent()
   {
      assert ProcessObserverMethodObserver.getEventtypes().contains(EventA.class);
   }

   @Test
   @SpecAssertion(section = "11.5.9", id = "aba")
   public void testGetAnnotatedMethod()
   {
      assert ProcessObserverMethodObserver.getAnnotatedMethod().getParameters().iterator().next().getBaseType().equals(EventA.class);
   }

   @Test
   @SpecAssertion(section = "11.5.9", id = "ba")
   public void testGetObserverMethod()
   {
      assert ProcessObserverMethodObserver.getObserverMethod().getObservedType().equals(EventA.class);
   }
   
}
