package org.springframework.jenkins.common.job

import groovy.transform.CompileStatic

/**
 * Defaults for JDK
 *
 * @author Marcin Grzejszczak
 */
@CompileStatic
trait JdkConfig {

	String jdk12() {
		return "jdk12"
	}

	String jdk11() {
		return "jdk11"
	}

	String jdk10() {
		return "jdk10"
	}

	String jdk9() {
		return "jdk9"
	}

	String jdk8() {
		return "jdk8"
	}

	String jdk7() {
		return "jdk7"
	}

	String pathToJavaBinEnvVar() {
		return 'JAVA_PATH_TO_BIN'
	}

	String jdk8HomeEnvVar() {
		return 'JAVA_HOME'
	}

	String jdk8DefaultPath() {
		return '/opt/jdk-8'
	}
}
