package org.springframework.jenkins.common.job

import groovy.transform.CompileStatic

/**
 * Contains labels to provide build restrictions
 *
 * @author Marcin Grzejszczak
 */
@CompileStatic
trait Label {
	String aws() {
		return 'ec2-0'
	}

	String windows() {
		return 'win2012'
	}

	String ubuntu18_04() {
		return "ubuntu1804"
	}
}