# Release 3.3.3

Name: <span style="color: powderblue"><span class="glyphicon glyphicon-globe"></span> "onion ring powderblue globe"</span>

- [Download QW Control](https://download.qwcontrol.com/)
- [Sign up for Release Notes](https://www.qwcontrol.com/release-notes-signup)

## Overview

This is a jam packed release!  We've been working closely with many of our
partners to enhance QW Control's integration capabilities.
Below is a list of the new integration features included in 3.3.3:

A full suite of plugins for Datadog.  It's now possible to use
[Datadog as a Node Source](/administration/projects/resource-model-sources/datadog.md)
for your infrastructure, Send Datadog event payloads as a [Workflow](/manual/workflow-steps/datadog.md)[/Node Step](/manual/node-steps/datadog.md) or
[Notification](/manual/notifications/datadog.md), and [Mute/Unmute hosts](/manual/node-steps/datadog.md#mute-host) during a workflow

New [PagerDuty Workflow Steps](/manual/workflow-steps/pagerduty.md) for "Escalate Incident", "Run Response Play"
and "Send V2 Event".

Updated and enhanced [ServiceNow&reg; plugins](/manual/workflow-steps/servicenow.md) allow job writers to add any field to
the respective tables for incidents and change records.

A new [Amazon Web Services (AWS) SNS Webhook Plugin](/manual/webhooks/aws-sns-webhook.md)
streamlines setup of SNS services that trigger QW Control jobs by responding with
the appropriate setup response payload.

A new [GitHub Webhook Plugin](/manual/webhooks/github-webhook.md) allows for
using GitHub webhook secrets and also responds to setup confirmation payloads.

Also included are some important performance updates that help QW Control scale
with your organization.  The Project List Page now has pagination turned on by
default and other areas of the product were refined for faster response times with larger QW Control data sets.


## Issues

* [Increase jetty max form keys to 2000](https://github.com/qwcontrol/qwcontrol/pull/6429)
* [Update openssh plugin version to 2.0.1](https://github.com/qwcontrol/qwcontrol/pull/6427)
* [Migrate pre spring boot 2 cookie configs to valid configs](https://github.com/qwcontrol/qwcontrol/pull/6420)
* [HttpOnly session cookie disabled by default on QW Control 3.3.X](https://github.com/qwcontrol/qwcontrol/issues/6419)
* [ACL List paging](https://github.com/qwcontrol/qwcontrol/pull/6403)
* [Fix read validation of a job from another project](https://github.com/qwcontrol/qwcontrol/pull/6396)
* [Force a retry when executing script if file is busy because chmod executed just before](https://github.com/qwcontrol/qwcontrol/pull/6394)
* [Paged Project List](https://github.com/qwcontrol/qwcontrol/pull/6391)
* [Fix: "Null hostname value"](https://github.com/qwcontrol/qwcontrol/pull/6390)
* [Bring minio client library up to 7.1.0](https://github.com/qwcontrol/qwcontrol/pull/6389)
* [Fix reflective access warning for java.util.logging.](https://github.com/qwcontrol/qwcontrol/pull/6380)
* [Show project Readme on home page only when configured](https://github.com/qwcontrol/qwcontrol/pull/6375)
* [Enable dynamic property values in vue plugin UIs, fix Icon node enhancer plugin](https://github.com/qwcontrol/qwcontrol/pull/6368)
* [Fix logging system initialization](https://github.com/qwcontrol/qwcontrol/pull/6366)
* [Upgrade pywinrm to 2.0.9](https://github.com/qwcontrol/qwcontrol/pull/6359)
* [QW Control Job Replication plugin not pushing changes to remote QW Control](https://github.com/qwcontrol/qwcontrol/issues/6311)
* [Change http return when execution status is passive from 503 to 200](https://github.com/qwcontrol/qwcontrol/pull/6299)
* [Upgrade axios from 0.18.1 to 0.19.2](https://github.com/qwcontrol/qwcontrol/pull/6262)
* [Security upgrade lodash from 4.17.15 to 4.17.16](https://github.com/qwcontrol/qwcontrol/pull/6252)
* [Plugin UI Enhancement](https://github.com/qwcontrol/qwcontrol/pull/6192)
* [README content always appears on the Project Home page (3.3.0-PREVIEW2)](https://github.com/qwcontrol/qwcontrol/issues/6138)
* [Jobref not using target project acls to validate if it can be executed](https://github.com/qwcontrol/qwcontrol/issues/3157)

## Contributors

* Greg Schueler (gschueler)
* Greg Zapp (ProTip)
* Jaime Tobar (jtobard)
* Loren Jamison (sornerol)
* Stephen Joyner (sjrd218)
* carlos
* Luis Toledo (ltamaster)
* Chris McG (chrismcg14)

## Bug Reporters

* G3NSVRV
* MegaDrive68k
* carlosrfranco
* gschueler
* jplassnibatt
* jtobard
* ltamaster
* sjrd218
* sornerol
