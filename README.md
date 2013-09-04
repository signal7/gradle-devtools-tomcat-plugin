gradle-devtools-tomcat-plugin
=============================

[![Build Status](https://travis-ci.org/signal7/gradle-devtools-tomcat-plugin.png)](https://travis-ci.org/signal7/gradle-devtools-tomcat-plugin)

Gradle plugin for eclipse devtools tomcat plugin



##Usage

	apply plugin: "eclipse"
	apply plugin: "devtools-tomcat"
	
	tomcatDescriptor {
		host = "core"
		// name =  "My Awesome Webapp" //default is <projectName>
		path = "/" // default is "/<projectName>"
		docBase = "/deployment$deploymentBase/$deploymentProjectBase"
		name = project.name
		path = "/" + project.name
	}
	
