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
package org.jboss.jsr299.tck.tests.definition.stereotype.broken.withBindingType;


import org.jboss.jsr299.tck.AbstractJSR299Test;
import org.jboss.test.audit.annotations.SpecVersion;
import org.jboss.testharness.impl.packaging.Artifact;

@Artifact
//@ExpectedDeploymentException(DefinitionError.class)
@SpecVersion(spec="cdi", version="20091018")
public class StereoTypeWithBindingTypesTest extends AbstractJSR299Test
{
   
   // @Test
   //@SpecAssertion(section = "2.7.1.3", id = "b")  now untestable
   public void testStereotypeWithBindingTypes()
   {
      assert false;
   }
   
}
