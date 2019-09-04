package com.plugin.samplegroovyworkflowstep;

import com.dtolabs.rundeck.core.execution.workflow.steps.FailureReason;
import com.dtolabs.rundeck.core.execution.workflow.steps.StepException;
import com.dtolabs.rundeck.core.plugins.Plugin;
import com.dtolabs.rundeck.core.plugins.configuration.Describable;
import com.dtolabs.rundeck.core.plugins.configuration.Description;
import com.dtolabs.rundeck.plugins.ServiceNameConstants;
import com.dtolabs.rundeck.plugins.descriptions.PluginDescription;
import com.dtolabs.rundeck.plugins.descriptions.PluginProperty;
import com.dtolabs.rundeck.plugins.step.PluginStepContext;
import com.dtolabs.rundeck.plugins.step.StepPlugin;
import com.dtolabs.rundeck.plugins.util.DescriptionBuilder;
import com.dtolabs.rundeck.plugins.util.PropertyBuilder;
import com.dtolabs.rundeck.plugins.PluginLogger;
import java.util.Map;

@Plugin(service=ServiceNameConstants.WorkflowStep,name="sample-groovy-workflow-step")
@PluginDescription(title="SampleGroovyWorkflowStep", description="My Workflow Step plugin description")
public class SampleGroovyWorkflowStep implements StepPlugin {


    @PluginProperty(title = "Sample Property",description = "Describe your property here")
    String sampleProperty
   /**
     * This enum lists the known reasons this plugin might fail
     */
   static enum Reason implements FailureReason{
        ExampleReason
   }


   /**
     * Here is the meat of the plugin implementation, which should perform the appropriate logic for your plugin.
     * <p/>
     * The {@link PluginStepContext} provides access to the appropriate Nodes, the configuration of the plugin, and
     * details about the step number and context.
     */
   @Override
   public void executeStep(final PluginStepContext context, final Map<String, Object> configuration) throws
                                                                                                      StepException{
       //Your logic goes here

       //Sample logic
        PluginLogger logger= context.getLogger();
        logger.log(2,"Sample property value: " + sampleProperty);
        logger.log(2,"Example step num: " + context.getStepNumber());
        logger.log(2,"Example step context: " + context.getStepContext());

       //Report errors like this:
       //throw new StepException("Something bad happened",Reason.ExampleReason)
   }

}