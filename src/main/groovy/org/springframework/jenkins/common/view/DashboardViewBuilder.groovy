package org.springframework.jenkins.common.view

import javaposse.jobdsl.dsl.DslFactory
import javaposse.jobdsl.dsl.JobParent
import javaposse.jobdsl.dsl.View

class DashboardViewBuilder {

	private final DslFactory dslFactory

	DashboardViewBuilder(DslFactory dslFactory) {
		this.dslFactory = dslFactory
	}

	View buildDashboard() {
		JobParent jobParent = dslFactory as JobParent
		View view = new Dashboard(jobParent.jm)
		jobParent.referencedViews << view
		return view
	}

}