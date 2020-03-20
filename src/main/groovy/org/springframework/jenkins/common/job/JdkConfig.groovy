package org.springframework.jenkins.common.job

import groovy.transform.CompileStatic

/**
 * Defaults for JDK
 *
 * @author Marcin Grzejszczak
 */
@CompileStatic
trait JdkConfig {

	String jdk15() {
		return "openjdk15"
	}

	String jdk14() {
		return "openjdk14"
	}

	String jdk13() {
		return "openjdk13"
	}

	String jdk12() {
		return "openjdk12"
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

	String openJdk7() {
		return "linux&&jdk7"
	}
}
