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

import javax.ejb.Stateless;
import javax.enterprise.inject.New;
import javax.inject.Inject;

import org.jboss.jsr299.tck.literals.NewLiteral;

@Stateless
public class ExplicitConstructorSessionBean implements ExplicitConstructor
{

   private static int constructorCalls = 0;
   private static SimpleBean injectedSimpleBean;
   
   public static final New NEW = new NewLiteral()
   {
      
      public Class<?> value()
      {
         return ExplicitConstructorSessionBean.class;
      }
   };
   
   public ExplicitConstructorSessionBean(){}
   
   @Inject
   public ExplicitConstructorSessionBean(SimpleBean bean)
   {
      constructorCalls++;
      injectedSimpleBean = bean;
   }

   public int getConstructorCalls()
   {
      return constructorCalls;
   }

   public void setConstructorCalls(int numCalls)
   {
      constructorCalls = numCalls;
   }

   public SimpleBean getInjectedSimpleBean()
   {
      return injectedSimpleBean;
   }

   public void setInjectedSimpleBean(SimpleBean injectedSimpleBean)
   {
      ExplicitConstructorSessionBean.injectedSimpleBean = injectedSimpleBean;
   }

}
