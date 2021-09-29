# Version 2.5.1



# Release 2.5.1
=============

Date: 2015-05-15

Name: <span style="color: seagreen"><span class="glyphicon glyphicon-sunglasses"></span> "cafe au lait seagreen sunglasses"</span>

This release has primarily bugfixes.

## Enhancements

* CLI tools can authenticate to the server using environment variables instead of the credentials stored in the framework.properties file.
	* see [CLI Tool Authentication](/manpages/man1/rd.md)

## Upgrading to 2.5

**Note:** We've attempted to maintain compatibility with previous plugins, but due to changes in the core library,
QW Control may have issues loading or running some plugins.

Please report issues found to [Github issues](https://github.com/qwcontrol/qwcontrol/issues).

See the [Upgrading Guide](/upgrading/upgrading.md)

## Contributors

* Greg Schueler (gschueler)

## Bug Reporters

* Zophar78
* andham
* arthurlogilab
* ctgaff
* danifr
* dspinellis
* gschueler
* harlanbarnes
* hbakkum
* jasonaughton
* michlaustn
* mikeleigh
* rveznaver
* schast
* snebel29
* tiahino
* wcooley

## Issues

* [Job with a negative threadcount causes exception when using Orchestrator](https://github.com/qwcontrol/qwcontrol/issues/1239)
* [Failed job runs not shown in 'failed' tab](https://github.com/qwcontrol/qwcontrol/issues/1234)
* [Information missing from aclpolicy docs](https://github.com/qwcontrol/qwcontrol/issues/1232)
* [Saved Node Filters shown in all projects, will show node results from other projects](https://github.com/qwcontrol/qwcontrol/issues/1231)
* [Job copy: Data Binding Failed](https://github.com/qwcontrol/qwcontrol/issues/1228)
* [Archive import fails if db still has varchar(7) in actionType column](https://github.com/qwcontrol/qwcontrol/issues/1227)
* [running rd-project without -p argument causes NPE](https://github.com/qwcontrol/qwcontrol/issues/1226)
* [Change to "If a step fails" selection for workflow isn't persisted](https://github.com/qwcontrol/qwcontrol/issues/1224)
* [Email Reporting Error On Success](https://github.com/qwcontrol/qwcontrol/issues/1221)
* [edit job step when plugin cannot be loaded causes javascript error](https://github.com/qwcontrol/qwcontrol/issues/1220)
* [rd-acl create -i doesn't correctly parse node tags in resource section](https://github.com/qwcontrol/qwcontrol/issues/1219)
* [rd-acl test with -t tags doesn't work properly](https://github.com/qwcontrol/qwcontrol/issues/1218)
* [QW Control start fails in Tomcat 7 on Win2012](https://github.com/qwcontrol/qwcontrol/issues/1216)
* [Error requesting json on API](https://github.com/qwcontrol/qwcontrol/issues/1215)
* [Updating job with orchestrator fails](https://github.com/qwcontrol/qwcontrol/issues/1212)
* [Incomplete view in Node list](https://github.com/qwcontrol/qwcontrol/issues/1208)
* [Limiting execution output through API with lastlines seems to be off by 2](https://github.com/qwcontrol/qwcontrol/issues/1207)
* [QW Control rpm package should conditionally restart the service on upgrade](https://github.com/qwcontrol/qwcontrol/issues/1199)
* [No signature of method: qwcontrol.services.ProjectService.exportProjectToFileAsync() when trying to export project archive with the DB storage type](https://github.com/qwcontrol/qwcontrol/issues/1198)
* [Key Storage - DB Backend Exception - Could not obtain current Hibernate Session](https://github.com/qwcontrol/qwcontrol/issues/1197)
* [Unable to save changes to jobs using Local Command node step](https://github.com/qwcontrol/qwcontrol/issues/1193)
* [2.5 debian package should require java 7](https://github.com/qwcontrol/qwcontrol/issues/1192)
* [Bulk Delete Execution Failing](https://github.com/qwcontrol/qwcontrol/issues/1184)
* [JettyCombinedLdapLoginModule -\> case sensitve](https://github.com/qwcontrol/qwcontrol/issues/1182)
* [Email Notifications Broken - ERROR NotificationService](https://github.com/qwcontrol/qwcontrol/issues/1181)
* [Jobs don't complete: Data truncation: Data too long for column 'action_type' at row 1](https://github.com/qwcontrol/qwcontrol/issues/1179)
* [qwcontrol.gui.login.welcomeHtml option is not rendering HTML](https://github.com/qwcontrol/qwcontrol/issues/1177)
* [org.h2.jdbc.JdbcSQLException: Feature not supported: "isWrapperFor"](https://github.com/qwcontrol/qwcontrol/issues/1175)
* [documentation: workflow node step plugin java interface shown is wrong](https://github.com/qwcontrol/qwcontrol/issues/1174)
* [Documentation: Missing execution data attributes on notification plugin page](https://github.com/qwcontrol/qwcontrol/issues/1035)
* [Re-write command line tools to support auth w/o properties file.](https://github.com/qwcontrol/qwcontrol/issues/137)