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
package org.jboss.jsr299.tck.tests.implementation.enterprise.newBean;

import javax.enterprise.inject.New;
import javax.inject.Inject;

/**
 * The container discovers <code>@New</code> qualified beans by inspecting injection points other enabled beans.
 * 
 * See also CDITCK-250.
 * 
 * @author Martin Kouba
 */
public class NewSessionBeanConsumer {

    @Inject
    @New(Order.class)
    OrderLocal order;

    @Inject
    @New(Monkey.class)
    MonkeyLocal monkey;

    @Inject
    @New(Lion.class)
    LionLocal lion;

    @Inject
    @New(InitializerSimpleBean.class)
    InitializerSimpleBeanLocal initializerSimpleBean;

    @Inject
    @New(Fox.class)
    FoxLocal fox;

    @Inject
    @New(ExplicitConstructorSessionBean.class)
    ExplicitConstructor explicitConstructor;
    
    @Inject
    @New(WrappedEnterpriseBean.class)
    WrappedEnterpriseBeanLocal wrappedEnterpriseBean;

}
