# Job plugins

## Node Steps

- [AWS EC2 Node Step Plugin](/en/user-guide/node-steps/aws.md)
- [Azure Node Step Plugins (Enterprise)](/en/user-guide/node-steps/azure.md)
- [Google Cloud Platform Plugins (Enterprise)](/en/user-guide/node-steps/gcp.md)
- [Oracle Cloud Node Steps plugins (Enterprise)](/en/user-guide/node-steps/oracle.md)
- [Datadog Node Step Plugins (Enterprise)](/en/user-guide/node-steps/datadog.md)
- [Jira Node Step Plugins (Enterprise)](/en/user-guide/node-steps/jira.md)
- [Sensu Node Step Plugins (Enterprise)](/en/user-guide/node-steps/sensu.md)
- [SQL Runner (Enterprise)](/en/user-guide/node-steps/sqlrunner.md)
- [VMWare Operations Node Step Plugin (Enterprise)](/en/user-guide/node-steps/vmware.md)
- [Command step](/en/user-guide/node-steps/builtin.md#command-step)
- [Script step](/en/user-guide/node-steps/builtin.md#script-step)
- [Script file](/en/user-guide/node-steps/builtin.md#script-file-step)
- [Script URL](/en/user-guide/node-steps/builtin.md#script-url-step)
- [Job reference](/en/user-guide/node-steps/builtin.md#job-reference-step)
- [Copy file](/en/user-guide/node-steps/builtin.md#copy-file-step)
- [Local command](/en/user-guide/node-steps/builtin.md#local-command-step)
- [Data node](/en/user-guide/node-steps/builtin.md#data-node-step)
- [HTTP Request](/en/user-guide/node-steps/builtin.md#http-node-step)


## Workflow Steps

- [Amazon Web Services(Enterprise)](/en/user-guide/workflow-steps/aws.md)
- [Azure Job Steps (Enterprise)](/en/user-guide/workflow-steps/azure.md)
- [Google Cloud Platform (Enterprise)](/en/user-guide/workflow-steps/gcp.md)
- [Oracle Cloud Infrastructure(Enterprise)](/en/user-guide/workflow-steps/oracle.md)
- [Datadog Workflow Step Plugins (Enterprise)](/en/user-guide/workflow-steps/datadog.md)
- [File Transfer (Enterprise)](/en/user-guide/workflow-steps/file-transfer.md)
- [Github (Enterprise)](/en/user-guide/workflow-steps/github.md)
- [Jira Workflow Step Plugins (Enterprise)](/en/user-guide/workflow-steps/jira.md)
- [PagerDuty (Enterprise)](/en/user-guide/workflow-steps/pagerduty.md#pager-duty-job-steps-enterprise)
- [Progress Badge (Enterprise)](/en/user-guide/workflow-steps/progress-badge.md#progress-badge-workflow-step-plugin)
- [Sensu Workflow Step Plugins (Enterprise)](/en/user-guide/workflow-steps/sensu.md)
- [ServiceNow (Enterprise)](/en/user-guide/workflow-steps/servicenow.md)
- [VMWare Step Plugins (Enterprise)](/en/user-guide/workflow-steps/vmware.md)
- [Ansible module](/en/user-guide/workflow-steps/builtin.md#ansible-module)
- [Ansible playbook inline](/en/user-guide/workflow-steps/builtin.md#ansible-playbook-inline)
- [Ansible playbook](/en/user-guide/workflow-steps/builtin.md#ansible-playbook)
- [Global variable](/en/user-guide/workflow-steps/builtin.md#global-variable)
- [Flow control](/en/user-guide/workflow-steps/builtin.md#flow-control)
- [Job state conditional](/en/user-guide/workflow-steps/builtin.md#job-state-conditional)
- [Log data step](/en/user-guide/workflow-steps/builtin.md#log-data-step)
- [Refresh project nodes](/en/user-guide/workflow-steps/builtin.md#refresh-project-nodes)
- [Data step](/en/user-guide/workflow-steps/builtin.md#data-step)

## Notifications

Notification plugins allow QW Control to communicate changes in job execution state and notify other users of successful or failed runs. For a general explanation on how job notifications work, see [Job Notifications](/en/user-guide/creating-jobs.md#job-notifications).

- [Jira Notification Plugins (Enterprise)](/en/user-guide/notifications/jira.md)
- [Jenkins Notification Plugin (Enterprise)](/en/user-guide/notifications/jenkins.md)
- [Datadog Notification Plugin (Enterprise)](/en/user-guide/notifications/datadog.md)
- [PagerDuty Notification Plugin (Enterprise)](/en/user-guide/notifications/pagerduty.md)
- [ServiceNow Notification Plugin (Enterprise)](/en/user-guide/notifications/servicenow.md)
- [Slack Notification Plugin (Enterprise)](/en/user-guide/notifications/slack.md)
- [Email](/en/user-guide/notifications/email.md)
- [Webhooks](/en/user-guide/notifications/webhooks.md)

For directions on how to use the Notification interface, see [here](/en/user-guide/notifications/interface-instructions.md).


## Option Plugins

Option Plugins provide dynamic Allowed Value lists to help choose the proper inputs for your jobs.  For general overview of how Options work see [Job Options](/en/user-guide/job-options.md)

- [Jira Option Plugins](/en/user-guide/option-plugins/jira.md)


## Workflow Strategy

The Workflow Strategy determines how the steps are processed within a Job's Workflow.

- [Ruleset (Enterprise)](/en/user-guide/workflow-strategies/ruleset.md)

## Node Orchestrator

Typically, QW Control processes nodes in the exact order that they are specified within a Job definition. An *Orchestrator Plugin* allows this run order to be modified by selecting a subset of nodes. This would be useful in order to limit concurrent executions during a deployment or gradually role out a new job to allow for testing.

The Bundled plugins support random selection, ordering by ranked tier, or specifying a percentage of nodes to target. If more logic or specificity is required, the Enterprise edition supports the selection of a single node based upon the value of an attribute.

- [Highest/Lowest Attribute Value (Enterprise)](/en/user-guide/orchestrator-plugins/highest-lowest.md)
- [Bundled Orchestrator Plugins](/en/user-guide/orchestrator-plugins/bundled.md)

## Log Filters

Log Filters can transform or aggregate output from one or more Workflow states.

- [Mask Passwords](/en/user-guide/log-filters/mask-passwords.md)
- [Render Formatted Data](/en/user-guide/log-filters/render-formatted-data.md)
- [Key Value Data](/en/user-guide/log-filters/key-value-data.md)
- [Quiet Output](/en/user-guide/log-filters/quiet-output.md)
- [Highlight Output](/en/user-guide/log-filters/highlight-output.md)
- [Progress Badge](/en/user-guide/log-filters/progress-badge.md)

## Content Converters

Content Converters are not added directly to Jobs, but can be used by Log Filters and Step plugins to render log output as HTML or Markdown within the QW Control User Interface.

See [Content Converter Plugins](/en/user-guide/content-converters/index.md).

## Execution Lifecycle

See [Execution Lifecycle Plugins](/en/user-guide/execution-lifecycle/index.md).
