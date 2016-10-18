/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat Inc., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.additional.testsuite.jdkall.present.management.deploy.runtime;

import java.rmi.RemoteException;

import javax.annotation.Resource;
import javax.ejb.RemoteHome;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import org.jboss.eap.additional.testsuite.annotations.EapAdditionalTestsuite;

/**
 * @author Stuart Douglas
 */
@Stateful
@RemoteHome(SimpleStatefulHome.class)
@EapAdditionalTestsuite({"modules/testcases/jdkAll/Eap7/management/src/main/java","modules/testcases/jdkAll/Eap70x/management/src/main/java","modules/testcases/jdkAll/WildflyRelease/management/src/main/java","modules/testcases/jdkAll/Wildfly/management/src/main/java","modules/testcases/jdkAll/Eap64x/management/src/main/java","modules/testcases/jdkAll/Eap64x-Proposed/management/src/main/java","modules/testcases/jdkAll/Eap63x/management/src/main/java","modules/testcases/jdkAll/Eap62x/management/src/main/java","modules/testcases/jdkAll/Eap61x/management/src/main/java"})
public class SimpleStatefulBean {

    @Resource
    private SessionContext sessionContext;

    private String message;

    public void ejbCreateSimple(String message) {
        this.message = message;
    }

    public void ejbCreateComplex(String first, String second) {
        this.message = first + " " + second;
    }

    public String sayHello() {
        return message;
    }

    public String otherMethod() throws RemoteException {
        return ((SimpleInterface)sessionContext.getEJBObject()).sayHello();
    }
}