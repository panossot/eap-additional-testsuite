package org.jboss.additional.testsuite.jdkall.present.infinispan.distributable.log;

import java.util.regex.Pattern;
import org.jboss.eap.additional.testsuite.annotations.EapAdditionalTestsuite;

/**
 * Interface describing utility which checks a log
 */
@EapAdditionalTestsuite({"modules/testcases/jdkAll/Wildfly/infinispan/src/main/java#19.0.0.Beta1","modules/testcases/jdkAll/Eap7/infinispan/src/main/java#3.0.0","modules/testcases/jdkAll/Eap72x/infinispan/src/main/java#7.2.8","modules/testcases/jdkAll/Eap72x-Proposed/infinispan/src/main/java#7.2.8"})
public interface LogChecker {

    /**
     * Perform search in log or its excerpt and find if a line matches the pattern.
     * 
     * @param pattern a pattern which will be the log line matched against
     * @return true if log line matching pattern was found in log, false otherwise
     */
    boolean logMatches(final Pattern pattern);

    /**
     * Perform search in log or its excerpt and find if a line contains a sub string.
     * 
     * @param subString a sub string which will be used to perform search among lines
     * @return true if log line containing a sub string was found in log, false otherwise
     */
    boolean logContains(final String subString);

}
