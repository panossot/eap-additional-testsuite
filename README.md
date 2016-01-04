# JBOSS ADDITIONAL TESTSUITE
An additional JBOSS testsuite in order to facilitate QE.

Write your tests once and run them on both EAP and WILDFLY application server.


HOW TO USE:

TESTING AGAINST EAP APPLICATION SERVER

1. Make sure that JBOSS_FOLDER environment variable is set with the path to your JBOSS EAP directory.
2. Build and run the additional testsuite activating the EAP profile (-Deap).


TESTING AGAINST WILDFLY APPLICATION SERVER

1. Make sure that JBOSS_FOLDER environment variable is set with the path to your WILDFLY directory.
2. Build and run the additional testsuite activating the WILDFLY profile (-Dwildfly).


TESTING AGAINST EAP OR WILDFLY APPLICATION SERVER USING SPECIFIC JDK VERSION

1. Make sure that JBOSS_FOLDER is set with the path to your EAP OR WILDFLY directory.
2. Make sure that JAVA_HOME is pointing to the jdk of desired version.
3. Build and run the additional testsuite activating the EAP or WILDFLY specific jdk version profile (-Deap-jdk8, -Dwildfly-jdk8).


#License 
* [GNU Lesser General Public License Version 2.1](http://www.gnu.org/licenses/lgpl-2.1-standalone.html)

