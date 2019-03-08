package org.jboss.additional.testsuite.jdkall.present.web.security.identity.propagation.deployment;

import org.jboss.eap.additional.testsuite.annotations.EapAdditionalTestsuite;

@EapAdditionalTestsuite({"modules/testcases/jdkAll/Eap72x/web/src/main/java#7.2.1", "modules/testcases/jdkAll/Eap72x-Proposed/web/src/main/java#7.2.1"})
public interface Hello {

    void call();
}
