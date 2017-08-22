#!/bin/bash

set -e

readonly JBOSS_VERSION_CODE=${1}
readonly SETTINGS_XML=${SETTINGS_XML:-"$(pwd)/settings.xml"}

usage() {
  local script_name=$(basename ${0})

  echo "${script_name} <jboss-version-code>"
  echo
  echo "Ex: ${script_name} wildfly"
  echo
  echo "On top of those arguments, this script excepts the following env vars to be set:"
  echo '- MAVEN_HOME, set to the appropriate directory containing the Maven distribution'
  echo '- JBOSS_VERSION, set the version used for labelling jar dependencies associate to the AS version.'
  echo "- JBOSS_FOLDER, path to the server built in the previous repository, default to '${JBOSS_FOLDER}'."
  echo "- MAVEN_LOCAL_REPOSITORY, path to a local mave repository to use for dependencies."
}

if [ -z "${JBOSS_VERSION_CODE}" ]; then
  echo "Missing JBOSS_VERSION_CODE (eap7, eap64,...)."
  usage
  exit 1
fi

if [ -z "${MAVEN_HOME}" ]; then
  echo "No MAVEN_HOME has been defined."
  exit 2
fi

if [ ! -e "${MAVEN_HOME}" ]; then
  echo "Provided MAVEN_HOME does not exist: ${MAVEN_HOME}"
  exit 3
fi

if [ ! -d "${MAVEN_HOME}" ]; then
  echo "Provided MAVEN_HOME is not a directory: ${MAVEN_HOME}"
  exit 4
fi

if [ -e "${SETTINGS_XML}" ]; then
  readonly SETTINGS_XML_OPTION="-s ${SETTINGS_XML}"
fi

if [ -d "${MAVEN_LOCAL_REPOSITORY}" ]; then
  readonly MAVEN_LOCAL_REPOSITORY_OPTION="-Dmaven.repo.local=${MAVEN_LOCAL_REPOSITORY}"
fi

if [ ! -d "${JBOSS_FOLDER}" ]; then
  echo "The folder provided for JBoss AS server using the JBOSS_FOLDER env  is not a directory: ${JBOSS_FOLDER}."
  exit 5
fi

#
# Setting up maven
#

export MAVEN_HOME
export PATH="${MAVEN_HOME}/bin:${PATH}"

export MAVEN_OPTS="${MAVEN_OPTS} -Dmaven.wagon.http.pool=false"
export MAVEN_OPTS="${MAVEN_OPTS} -Dmaven.wagon.httpconnectionManager.maxPerRoute=3"
export MAVEN_OPTS="${MAVEN_OPTS} -Xmx1024m -Xms512m -XX:MaxPermSize=256m"

#
# Run EAT
#
echo "Runing EAT on JBoss server: ${JBOSS_FOLDER}"
mvn clean install -D${JBOSS_VERSION_CODE} -Dstandalone ${SETTINGS_XML_OPTION} ${MAVEN_LOCAL_REPOSITORY_OPTION}
