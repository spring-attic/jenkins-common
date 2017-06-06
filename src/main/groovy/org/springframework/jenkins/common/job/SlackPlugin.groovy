package org.springframework.jenkins.common.job

/**
 * A class represents a DSL to use with Slack Notification Plugin
 *
 * @author Marcin Grzejszczak
 */
class SlackPlugin {

	static Slack slackNotification(Node rootNode, @DelegatesTo(Slack) Closure closure) {
		Slack slack = new Slack(rootNode)
		closure.delegate = slack
		closure.call()
		return slack
	}

}
