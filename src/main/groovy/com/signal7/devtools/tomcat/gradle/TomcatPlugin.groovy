package com.signal7.devtools.tomcat.gradle

import org.gradle.api.Plugin;
import org.gradle.api.Project;

class TomcatPlugin implements Plugin<Project>{

	void apply(Project project){

		project.extensions.create("tomcatDescriptor", TomcatExtension, project)
		def outputFile = project.file(".tomcat")

		def	outputTomcatFileTask = project.task("outputTomcatFile") << {
			def writer = new StringWriter()
			def xml = new groovy.xml.MarkupBuilder(writer)
			xml.setDoubleQuotes(true)
			xml.'tomcat-project'{
				context(
						name: project.tomcatDescriptor.name,
						host: project.tomcatDescriptor.host,
						path: project.tomcatDescriptor.path,
						docBase: project.tomcatDescriptor.docBase
						)
			}
			outputFile.text=writer.toString()
		}
		project.tasks.eclipse.dependsOn(outputTomcatFileTask)

		outputTomcatFileTask.outputs.file outputFile

		// fixme
		outputTomcatFileTask.outputs.upToDateWhen {false}
	}
}
