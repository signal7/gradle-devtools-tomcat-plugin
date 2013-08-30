package com.signal7.devtools.tomcat.gradle

import org.gradle.api.Project;

class TomcatExtension {
	def name
	def host
	def path
	def docBase

	TomcatExtension(Project project){
		name = project.name
		path = "/" + project.name
	}
}