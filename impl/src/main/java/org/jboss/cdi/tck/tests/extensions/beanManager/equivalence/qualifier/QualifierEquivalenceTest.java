/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012, Red Hat, Inc., and individual contributors
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

package org.jboss.cdi.tck.tests.extensions.beanManager.equivalence.qualifier;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.lang.annotation.Annotation;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.cdi.tck.AbstractTest;
import org.jboss.cdi.tck.shrinkwrap.WebArchiveBuilder;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecAssertions;
import org.jboss.test.audit.annotations.SpecVersion;
import org.testng.annotations.Test;

/**
 * @author Martin Kouba
 * 
 */
@SpecVersion(spec = "cdi", version = "20091101")
public class QualifierEquivalenceTest extends AbstractTest {

    @Deployment
    public static WebArchive createTestArchive() {
        return new WebArchiveBuilder().withTestClassPackage(QualifierEquivalenceTest.class).build();
    }

    @SuppressWarnings("serial")
    @Test
    @SpecAssertions({ @SpecAssertion(section = "11.3.15", id = "a") })
    public void testAreQualifiersEquivalent() {

        Annotation literal1 = new MonsterQualifier() {
        };
        Annotation literal2 = new MonsterQualifier() {

            @Override
            public String position() {
                return "dungeon";
            }

        };
        Annotation containerProvided = getUniqueBean(Troll.class, literal1).getQualifiers().iterator().next();
        assertTrue(getCurrentManager().areQualifiersEquivalent(literal1, containerProvided));
        assertFalse(getCurrentManager().areQualifiersEquivalent(literal2, containerProvided));
        assertFalse(getCurrentManager().areQualifiersEquivalent(literal1, literal2));
    }

    @SuppressWarnings("serial")
    @Test
    @SpecAssertions({ @SpecAssertion(section = "11.3.15", id = "c") })
    public void testGetQualifierHashCode() {

        Annotation literal1 = new MonsterQualifier() {
        };
        Annotation literal2 = new MonsterQualifier() {

            @Override
            public int numberOfVictims() {
                return 7;
            }

            @Override
            public Level level() {
                return Level.B;
            }
        };
        Annotation containerProvided = getUniqueBean(Troll.class, literal1).getQualifiers().iterator().next();
        assertEquals(getCurrentManager().getQualifierHashCode(literal1),
                getCurrentManager().getQualifierHashCode(containerProvided));
        assertNotEquals(getCurrentManager().getQualifierHashCode(literal2),
                getCurrentManager().getQualifierHashCode(containerProvided));
        assertNotEquals(getCurrentManager().getQualifierHashCode(literal1), getCurrentManager().getQualifierHashCode(literal2));
    }
}
