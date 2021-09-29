# Release 3.3.4

Name: <span style="color: rebeccapurple"><span class="glyphicon glyphicon-grain"></span> "onion ring rebeccapurple grain"*</span>

- [Download QW Control](https://download.qwcontrol.com/)
- [Sign up for Release Notes](https://www.qwcontrol.com/release-notes-signup)

:::danger
**BUG NOTICE** If you are using Enterprise RPM or Debian packages you may have an issue with your license after upgrading to this version.  We are working on a fix that will be released with version 3.3.5.

Issue: If your server UUID is specified in the framework.properties it will not be recognized and that QW Control instance will appear to be unlicensed.
Workaround Steps:
- Use environment variables to pass the server ID as described on [this page](https://docs.qwcontrol.com/docs/administration/configuration/system-properties.html#rpm-and-deb)
- Setting to include `-Dqwcontrol.server.uuid=00000000-0000-0000-0000-000000000000` (replacing the zeros with your unique server ID)

:::

:::danger
**For MySQL users**: Starting with QW Control `3.3.4` the MySQL JDBC driver will no longer be
bundled with the distributions. See the [Upgrade Guide](/upgrading/upgrading-to-qwcontrol-3.3.4.md)
for instructions to ensure your QW Control installation can still connect to MySQL after upgrading.
:::

## Overview

QW Control 3.3.4 is another jam packed release.  **Please note the warning above about MySQL**

QW Control Enterprise users have the option to use [HashiCorp Consul](https://www.consul.io) as a method to edit QW Control's configuration properties. By doing so, it allows users to manage the configuration for all of their services in one place. In terms of QW Control, this feature is very beneficial because it allows users to edit configurations across all of their QW Control instances. So, instead of having to change a configuration for each instance, change it once in Hashicorp and it will apply to all instances. [Check out the docs here.](https://docs.qwcontrol.com/docs/administration/configuration/hashicorp-consul.html)

The Notification Editor UI/UX has been revamped to better support the growing number of Notification plugins.
![New Notification Editor](~@assets/img/releasenotes-3.3.4-notifications.png)
Notifications can also now connect to Key Storage for centralized, secure secret retrieval.

Check out the new [configuration documentation](https://docs.qwcontrol.com/docs/administration/configuration/docker.html) for our Docker builds and information about how the [Remco Templates](https://docs.qwcontrol.com/docs/administration/configuration/docker/extending-configuration.html) are integrated to their deployment.



## Issues

* [Remove MySQL JDBC driver from bundle](https://github.com/qwcontrol/qwcontrol/pull/6511)
* [Upgrade mariadb driver to 2.7.0](https://github.com/qwcontrol/qwcontrol/pull/6502)
* [Quell reflective access messages.](https://github.com/qwcontrol/qwcontrol/pull/6500)
* [Fix #6357 disabling schedule in job edit does not work](https://github.com/qwcontrol/qwcontrol/pull/6492)
* [Fix #6304 where changing only the crontab would not update the scheduled execution.](https://github.com/qwcontrol/qwcontrol/pull/6490)
* [Speed up filesystem plugin access](https://github.com/qwcontrol/qwcontrol/pull/6485)
* [Fix: project list gui config values not working](https://github.com/qwcontrol/qwcontrol/pull/6470)
* [Update notifications: enable vue ui in production, update selenium tests](https://github.com/qwcontrol/qwcontrol/pull/6464)
* [Replace git plugin icon with font icon](https://github.com/qwcontrol/qwcontrol/pull/6460)
* [Upgrade pywinrm plugin : Add flag for enabling kerberos delegation](https://github.com/qwcontrol/qwcontrol/pull/6458)
* [Enable notification plugins to access key storage](https://github.com/qwcontrol/qwcontrol/pull/6457)
* [Fix #6449 - Sync command disabled as default and without arguments](https://github.com/qwcontrol/qwcontrol/pull/6456)
* [Remove unused fonts](https://github.com/qwcontrol/qwcontrol/pull/6455)
* [Add validation warning if node executor or file copy plugins are missing](https://github.com/qwcontrol/qwcontrol/pull/6454)
* ["sync: ignoring all arguments" warning message on script step (only on 3.3.3)](https://github.com/qwcontrol/qwcontrol/issues/6449)
* [Fix importOptions flag not importing correctly when uploading a job definition](https://github.com/qwcontrol/qwcontrol/pull/6444)
* [QW Control is not importing jobs from 2.4.x correctly](https://github.com/qwcontrol/qwcontrol/issues/6442)
* [UI Update: Notifications editor](https://github.com/qwcontrol/qwcontrol/pull/6438)
* [Node Executor or File Copier Plugin are missing #6436](https://github.com/qwcontrol/qwcontrol/pull/6437)
* [Minor product issue: If a node executor plugin is missing, the project's "Default Node Executor" section is blank](https://github.com/qwcontrol/qwcontrol/issues/6436)
* [Fix issue 5462 where SCP File Copier and SSH Node Executor have same properties which meant that the properties were not saved to the Default Node Executor when File Copier overwrote the changes. This change makes the properties to be saved, regardless of where they were changed (in File Copier or Node Executor properties).](https://github.com/qwcontrol/qwcontrol/pull/6434)
* [Fixes when send an email notification when a job is marked as "Incomplete" #6401](https://github.com/qwcontrol/qwcontrol/pull/6425)
* [Fix #6335 failOnDisable flag in jobref definition not serialized/loaded correctly](https://github.com/qwcontrol/qwcontrol/pull/6417)
* [QW Control initialization refactoring](https://github.com/qwcontrol/qwcontrol/pull/6414)
* [Fixes when send an email notification when a job is marked as "Incomplete" #6401](https://github.com/qwcontrol/qwcontrol/pull/6407)
* [When a job is marked as "Incomplete", the global variables are not being expanded in the email notification ](https://github.com/qwcontrol/qwcontrol/issues/6401)
* [Disabled Job and Disabled Schedule not honored ](https://github.com/qwcontrol/qwcontrol/issues/6357)
* [Job import/export removes failOnDisable: true](https://github.com/qwcontrol/qwcontrol/issues/6335)
* [Updating a JOB Crontab Schedule doesn't save new value](https://github.com/qwcontrol/qwcontrol/issues/6304)
* [Fix old property for contextPath was being used to set the context ref in the UI](https://github.com/qwcontrol/qwcontrol/pull/6516)


## Contributors

* Elagost (elagost)
* Greg Schueler (gschueler)
* Greg Zapp (ProTip)
* Jaime Tobar (jtobard)
* Nicole Valenzuela (nvalenzuela20)
* Stephen Joyner (sjrd218)
* carlos
* ltamaster

## Bug Reporters

* MegaDrive68k
* ProTip
* ajxb
* carlosrfranco
* gschueler
* hs-hub-world
* jtobard
* ltamaster
* nvalenzuela20
* ruiplcorreia
* sjrd218


<span style="color: rebeccapurple">*If you aren't familiar with the story of "rebeccapurple" [check out this blog](https://medium.com/@valgaze/the-hidden-purple-memorial-in-your-web-browser-7d84813bb416).</span>
