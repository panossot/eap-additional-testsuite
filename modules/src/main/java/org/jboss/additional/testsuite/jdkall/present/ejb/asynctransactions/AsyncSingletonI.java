package org.jboss.additional.testsuite.jdkall.present.ejb.asynctransactions;

import org.jboss.eap.additional.testsuite.annotations.EapAdditionalTestsuite;

@EapAdditionalTestsuite({"modules/testcases/jdkAll/Eap72x/ejb/src/main/java","modules/testcases/jdkAll/Eap72x-Proposed/ejb/src/main/java#7.2.8","modules/testcases/jdkAll/Eap71x/ejb/src/main/java","modules/testcases/jdkAll/Eap70x/ejb/src/main/java","modules/testcases/jdkAll/Eap64x/ejb/src/main/java","modules/testcases/jdkAll/Eap7/ejb/src/main/java#7.3.1","modules/testcases/jdkAll/Wildfly/ejb/src/main/java#19.0.0.Beta1"})
public interface AsyncSingletonI {
    void doAsyncAction();
}
