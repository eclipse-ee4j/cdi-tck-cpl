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

package org.jboss.jsr299.tck.tests.deployment.lifecycle;

import org.jboss.jsr299.tck.AbstractJSR299Test;
import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecAssertions;
import org.jboss.test.audit.annotations.SpecVersion;
import org.jboss.testharness.impl.packaging.Artifact;
import org.jboss.testharness.impl.packaging.IntegrationTest;
import org.jboss.testharness.impl.packaging.Resource;
import org.jboss.testharness.impl.packaging.Resources;
import org.jboss.testharness.impl.packaging.jsr299.BeansXml;
import org.testng.annotations.Test;

/**
 * Tests related to the final deployment phase of the lifecycle.
 * 
 * @author David Allen
 */
@Artifact
@Test
@SpecVersion(spec="cdi", version="20091101")
@BeansXml("beans.xml")
@Resources({
   @Resource(source="javax.enterprise.inject.spi.Extension.DeploymentTest", destination="WEB-INF/classes/META-INF/services/javax.enterprise.inject.spi.Extension")
})
@IntegrationTest
public class DeploymentTest extends AbstractJSR299Test
{
   @Test(groups="rewrite")
   @SpecAssertions({
      @SpecAssertion(section = "11.5.2", id = "a"),
      @SpecAssertion(section = "11.5.3", id = "a"),
      @SpecAssertion(section = "12.2", id = "g")
   })
   public void testDeployedManagerEvent()
   {
      assert ManagerObserver.isAfterDeploymentValidationCalled();
      // Make sure the manager does accept requests now
      getCurrentManager().fireEvent("event");
   }

   @Test(groups = {})
   @SpecAssertions({
      @SpecAssertion(section = "11.1", id = "f")
   })
   public void testOnlyEnabledBeansDeployed()
   {
      assert !getBeans(User.class).isEmpty();
      assert getBeans(DataAccessAuthorizationDecorator.class).isEmpty();
      assert getBeans(Interceptor1.class).isEmpty();
      assert getBeans(DisabledBean.class).isEmpty();
   }
}
