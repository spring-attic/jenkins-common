package org.springframework.jenkins.common.job

/**
 * Trait for default setup of Deliver Pipeline version
 *
 * @author Marcin Grzejszczak
 */
trait Pipeline {
	Closure defaultDeliveryPipelineVersion() {
		return {
			deliveryPipelineVersion('BUILD-${BUILD_NUMBER}', true)
		}
	}
}