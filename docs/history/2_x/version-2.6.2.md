# Version 2.6.2



# Release 2.6.2
===========

Date: 2015-12-02

Name: <span style="color: crimson"><span class="glyphicon glyphicon-headphones"></span> "cafe bonbon crimson headphones"</span>

## Notes

This release includes bug fixes, and some enhancements.

* Secure Job Options can now use Key Storage for defaults, enabling use via scheduled jobs
* Quartz thread pool info and warnings added to system info
* API added for SCM plugins, API version updated to v15
* Plugins: input property definitions can now be placed in groups, which can be shown collapsed by default

## Contributors

* Greg Schueler (gschueler)

## Bug Reporters

* ahonor
* gschueler
* sea-lmarchal
* stack72

## Issues

* [Feature/multifile storage](https://github.com/qwcontrol/qwcontrol/pull/1560)
* [SCM API: push via project-commit action not working](https://github.com/qwcontrol/qwcontrol/issues/1553)
* [SCM API: plugin type not checked for enable/disable](https://github.com/qwcontrol/qwcontrol/issues/1552)
* [SSH debug logging is missing](https://github.com/qwcontrol/qwcontrol/issues/1546)
* [plugin properties can be grouped](https://github.com/qwcontrol/qwcontrol/pull/1543)
* [Feature: secure option can use key store for default values](https://github.com/qwcontrol/qwcontrol/pull/1537)
* [for #1535 allow qwcontrol.basedir var in remote option file urls](https://github.com/qwcontrol/qwcontrol/pull/1536)
* [Expand ${rdeck.base} for remoteUrl paths for options](https://github.com/qwcontrol/qwcontrol/issues/1535)
* [2.6: startup message "Event listener qwcontrol.services.JobEventsService#jobChanged declared for topic jobChanged and namespace app but no such event is declared, you may never receive it"](https://github.com/qwcontrol/qwcontrol/issues/1532)
* [Add Quartz Scheduler threadPool usage to metrics healthcheck, system info](https://github.com/qwcontrol/qwcontrol/pull/1530)
* [Startup: ERROR level log: "ScheduledExecutionService - rescheduled job: 335"](https://github.com/qwcontrol/qwcontrol/issues/1529)
* [Job succeeds instead of failing when executing a job-ref at the end](https://github.com/qwcontrol/qwcontrol/issues/1528)
* [API for SCM plugins](https://github.com/qwcontrol/qwcontrol/pull/1526)
* [SCM: add API support for SCM plugins](https://github.com/qwcontrol/qwcontrol/issues/1516)
* [Error Deleting a Project](https://github.com/qwcontrol/qwcontrol/issues/1436)