package org.springframework.jenkins.common.job

/**
 * Trait with steps related to building and deploying artifacts
 *
 * @author Marcin Grzejszczak
 */
trait BuildAndDeploy {

	String prefixJob(String projectName) {
		if (projectName == projectSuffix()){
			return projectName
		}
		return projectName.startsWith(projectSuffix()) ? projectName : "${projectSuffix()}-${projectName}"
	}

	abstract String projectSuffix()

	String cleanAndDeploy() {
		return '''./mvnw clean deploy -nsu -P docs,integration -U $MVN_LOCAL_OPTS -Dmaven.test.redirectTestOutputToFile=true -Dsurefire.runOrder=random'''
	}

	String removeStubAndDeploy() {
		return """rm -rf ~/.m2/repository/com/example && rm -rf ~/.m2/repository/org/springframework/cloud/contract/verifier/stubs/ && ${cleanAndDeploy()}"""
	}

	String deployDocs() {
		return '''echo "Deploying docs" && ./docs/src/main/asciidoc/ghpages.sh'''
	}

	String branchVarName() {
		return 'BRANCH'
	}

	String branchVar() {
		return '$' + branchVarName()
	}

	String masterBranch() {
		return 'master'
	}
}