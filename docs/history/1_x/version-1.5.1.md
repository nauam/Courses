# Version 1.5.1



# Release 1.5.1
===========

Date: 2013-04-30

Notable Changes:

* Bug fixes
* Job Notification Plugins
    * Jobs can now trigger notification plugins in addition to the built-in email and webhook
    * plugins can be developed in Java or with a new Groovy DSL
    * See the [Notification Plugin Development](/developer/01-plugin-development.md) Chapter.
    * Example code at [dtolabs/qwcontrol/examples](https://github.com/dtolabs/qwcontrol/tree/development/examples)
* Notification 'onstart' trigger
    * Jobs can now cause a notification trigger when started via the 'onstart' trigger
* Notifications can now use the email address of the user who executed a job, as `${job.user.email}`. (You can set an email for your account in the Profile page.)

Contributors:

* Alex Honor
* Charles Duffy
* Greg Schueler
* John Burbridge
* Jonathan Li
* Kim Ho

Issues:

* [Add static ordering to job options instead of always sorted by name](https://github.com/dtolabs/qwcontrol/issues/361)
* [Add job notification plugins](https://github.com/dtolabs/qwcontrol/issues/360)
* [Big number as option default causes exception on load job from xml](https://github.com/dtolabs/qwcontrol/issues/356)
* [Job XML parse fails if "false" value in an command step](https://github.com/dtolabs/qwcontrol/issues/353)
* [Local error handling command lost on export / import](https://github.com/dtolabs/qwcontrol/issues/351)
* [error handler has exception when attempting to handle No Matched Nodes failure for a job reference](https://github.com/dtolabs/qwcontrol/issues/350)
* [Multi-value options not pre-populated when doing a "run again"](https://github.com/dtolabs/qwcontrol/issues/346)
* [API: add "asUser" feature for running/killing jobs and executions](https://github.com/dtolabs/qwcontrol/issues/341)
* [init script doesn't work on CentOS (one-line fix provided)](https://github.com/dtolabs/qwcontrol/issues/338)
* [job group changes before authorization check in 1.5](https://github.com/dtolabs/qwcontrol/issues/330)
* [Many ACL policy files can slow down the Project drop down menu](https://github.com/dtolabs/qwcontrol/issues/328)
* [Unable to generate an api-token on qwcontrol 1.5](https://github.com/dtolabs/qwcontrol/issues/327)
* [Cannot send notification email using 1.5](https://github.com/dtolabs/qwcontrol/issues/325)
* [Long description for Option causes Job import failure in 1.5 for jobs exported from 1.4](https://github.com/dtolabs/qwcontrol/issues/320)
* [1.5: GUI regression: Success rate % in job popup always shows 0%](https://github.com/dtolabs/qwcontrol/issues/316)
* [1.5: GUI regression: Job execution follow page: progress meter stuck](https://github.com/dtolabs/qwcontrol/issues/315)
* [Invalid XML char in log output breaks CLI output follow mode.](https://github.com/dtolabs/qwcontrol/issues/313)
* [1.5: html and ajax errors about "Timeout trying to lock table"](https://github.com/dtolabs/qwcontrol/issues/312)
* [sudo responder hangs](https://github.com/dtolabs/qwcontrol/issues/311)
* [CLIUtils.generateArgline does not quote IFS characters other than space](https://github.com/dtolabs/qwcontrol/issues/298)
* [documentation: upgrade guide "admin" aclpolicy doesn't allow all permissions](https://github.com/dtolabs/qwcontrol/issues/280)
* [Add Job Notification/webhook on job start](https://github.com/dtolabs/qwcontrol/issues/250)
* [projects folder under version control - .svn folder treated as project](https://github.com/dtolabs/qwcontrol/issues/209)
* [incorrect aclpolicy yaml structure can cause NPE](https://github.com/dtolabs/qwcontrol/issues/206)
* [Options are not passed correctly to programs](https://github.com/dtolabs/qwcontrol/issues/201)
* [Allow Email Address substitution in notification recipients list](https://github.com/dtolabs/qwcontrol/issues/165)
