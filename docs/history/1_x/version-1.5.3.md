# Version 1.5.3



# Release 1.5.3
===========

Date: 2013-05-30

Notable Changes:

* bug fixes
* plugins can define input properties that get displayed as textareas in the gui

Incubator changes:

* cluster mode, which allows scheduled (cron) jobs to only run on a single node when multiple QW Control servers share a single DB. (Note: "incubator" features are experimental and likely to change)

Contributors:

* Alex Honor
* Greg Schueler
* Kim Ho

Issues:

* [Unable to create scheduled jobs if user has too many authorization roles](https://github.com/dtolabs/qwcontrol/issues/407)
* [Add customizable text in the login box.](https://github.com/dtolabs/qwcontrol/issues/405)
* [Authentication Page in manual lists wrong port for LDAPS](https://github.com/dtolabs/qwcontrol/issues/404)
* [deb packaging: rd-queue script has wrong perms](https://github.com/dtolabs/qwcontrol/issues/403)
* [JarPluginProviderLoader NPE if the pluginJar cache dir is not readable or does not exist](https://github.com/dtolabs/qwcontrol/issues/402)
* [deb/rpm packaging, cli tools use wrong rdeck.base value](https://github.com/dtolabs/qwcontrol/issues/401)
* [Secure option default values are not used by scheduled jobs](https://github.com/dtolabs/qwcontrol/issues/399)
* [Feature/cluster mode unique server for job schedules](https://github.com/dtolabs/qwcontrol/issues/396)
* [JSch authentication retries until server maxes out allowed attempts](https://github.com/dtolabs/qwcontrol/issues/393)
* [Add support for textarea rendering option for String property type](https://github.com/dtolabs/qwcontrol/issues/390)
* [deb/rpm packaging qwcontrol-config doesn't set grails.serverURL](https://github.com/dtolabs/qwcontrol/issues/387)
