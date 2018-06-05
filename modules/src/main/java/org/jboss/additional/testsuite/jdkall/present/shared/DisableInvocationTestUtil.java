package  org.jboss.additional.testsuite.jdkall.present.shared;

import org.jboss.eap.additional.testsuite.annotations.EapAdditionalTestsuite;

/**
 * @author Kabir Khan
 */
@EapAdditionalTestsuite({"modules/testcases/jdkAll/Eap7/ejb/src/main/java","modules/testcases/jdkAll/Eap7.1.0.Beta/ejb/src/main/java","modules/testcases/jdkAll/Wildfly/ejb/src/main/java"})
public class DisableInvocationTestUtil {
    public static void disable() {
        AssumeTestGroupUtil.assumeInvocationTestsEnabled();
    }
}
