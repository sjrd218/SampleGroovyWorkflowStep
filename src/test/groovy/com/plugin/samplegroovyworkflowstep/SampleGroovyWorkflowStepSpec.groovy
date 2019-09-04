package com.plugin.samplegroovyworkflowstep

import com.dtolabs.rundeck.plugins.step.PluginStepContext
import com.dtolabs.rundeck.core.execution.workflow.steps.StepException
import com.dtolabs.rundeck.plugins.PluginLogger
import spock.lang.Specification

class SampleGroovyWorkflowStepSpec extends Specification {

    def getContext(PluginLogger logger){
        Mock(PluginStepContext){
            getLogger()>>logger
        }
    }

    def "run OK"(){

        given:

        def example = new SampleGroovyWorkflowStep()
        def logger = Mock(PluginLogger)
        def context = getContext(logger)
        def configuration = [sampleProperty: "Val 1"]
        example.sampleProperty = "Val 1"

        when:
        example.executeStep(context,configuration)

        then:
        1 * logger.log(2, 'Sample property value: Val 1')
    }

}