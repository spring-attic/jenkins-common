package org.springframework.jenkins.common.job

/**
 * Trait containing setup for connecting to Cloud Foundry
 *
 * @author Marcin Grzejszczak
 */
trait BashCloudFoundry {

	String cfUsernameProp() {
		return '$CF_USERNAME'
	}

	String cfPasswordProp() {
		return '$CF_PASSWORD'
	}

	String cfUsername() {
		return 'CF_USERNAME'
	}

	String cfPassword() {
		return 'CF_PASSWORD'
	}

	String cfSpaceProp() {
		return '$' + cfSpacePropName()
	}

	String cfSpace() {
		return 'mgrzejszczak'
	}

	String cfSpacePropName() {
		return 'CF_SPACE'
	}

	String cfCredentialsId() {
		return 'PWS buildmaster@springframework.org'
	}

	String cfScriptToExecute(String script) {
		return """
						echo "Downloading Cloud Foundry"
						curl -L "https://cli.run.pivotal.io/stable?release=linux64-binary&source=github" | tar -zx

						echo "Setting alias to cf"
						alias cf=`pwd`/cf
						export cf=`pwd`/cf

						echo "Cloud foundry version"
						cf --version

						echo "Logging in to CF"
						cf api --skip-ssl-validation api.run.pivotal.io

						set +x
						cf login -u "${cfUsernameProp()}" -p "${cfPasswordProp()}" -o FrameworksAndRuntimes -s "${cfSpaceProp()}"
						set -x

						echo "Running script CF"
						bash ${script}
					"""
	}

}