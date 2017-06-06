package org.springframework.jenkins.common.job

/**
 * A class represents a DSL to use with JMH Performance plugin
 *
 * @author Marcin Grzejszczak
 */
class JmhPerformance {

	static void benchmarkPublisher(Node rootNode, @DelegatesTo(BenchmarkPublisher) Closure closure) {
		BenchmarkPublisher publisher = new BenchmarkPublisher(rootNode)
		closure.delegate = publisher
		closure.call()
	}

	static class BenchmarkPublisher {
		private final Node rootNode
		private final def configurator

		BenchmarkPublisher(Node rootNode) {
			this.rootNode = rootNode
			Node publishers = rootNode / 'publishers'
			this.configurator = publishers / 'blackboard.test.jenkins.jmhbenchmark.BenchmarkPublisher'
			performanceIncreaseThreshold()
			performanceDegradationThreshold()
			decimalPlaces()
			baselineBuildNumber()
		}

		void performanceIncreaseThreshold(int threshold = 20) {
			(configurator / '__performanceIncreaseThreshold').setValue(threshold)
		}

		void performanceDegradationThreshold(int threshold = -20) {
			(configurator / '__performanceDegradationThreshold').setValue(threshold)
		}

		void decimalPlaces(int places = 4) {
			(configurator / '__decimalPlaces').setValue(places)
		}

		void baselineBuildNumber(int buildNumber = 0) {
			(configurator / '__baselineBuildNumber').setValue(buildNumber)
		}
	}

}
