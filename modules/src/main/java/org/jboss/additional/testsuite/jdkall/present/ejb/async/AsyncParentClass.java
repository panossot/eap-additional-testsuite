package org.jboss.additional.testsuite.jdkall.present.ejb.async;

import javax.ejb.Asynchronous;
import org.jboss.eap.additional.testsuite.annotations.EapAdditionalTestsuite;

/**
 * @author Ondrej Chaloupka
 */
@Asynchronous
@EapAdditionalTestsuite({"modules/testcases/jdkAll/Eap7/ejb/src/main/java","modules/testcases/jdkAll/Eap7.1.0.Beta/ejb/src/main/java","modules/testcases/jdkAll/Wildfly/ejb/src/main/java"})
public class AsyncParentClass {
    public static volatile boolean voidMethodCalled = false;
}
