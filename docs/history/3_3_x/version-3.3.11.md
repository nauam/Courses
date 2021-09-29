# Release 3.3.11

Name: <span style="color: slategray"><span class="glyphicon glyphicon-phone"></span> "Onion ring slategray phone"</span>

- [Download QW Control](https://download.qwcontrol.com/)
- [Sign up for Release Notes](https://www.qwcontrol.com/release-notes-signup)

:::danger Package repositories have moved!
  Please read [the new instructions for downloading QW Control](/learning/howto/migrate-to-qwcontrol-packages-repo.md) from our new package repositories.
:::

## Overview
[SCM plugins](/administration/projects/scm/git) provide Source Code Management for jobs allowing QW Control admins to track versions and export and/or import definitions using a remote Git repository. With this release, the plugins are faster and more reliable in both Open Source and Enterprise versions.

## Enterprise Updates

* Fix: Job save fails if single cluster member in passive mode
* Sec: Addresses OWASP security findings.


## Core Product Updates

* [Fix: #6982 Plugin meta was not deleted with project](https://github.com/qwcontrol/qwcontrol/pull/7027)
* [Fix: Fix SCM job sourceId not appearing in exported file path ](https://github.com/qwcontrol/qwcontrol/pull/7026)
* [Fix: SCM import of renamed jobs](https://github.com/qwcontrol/qwcontrol/pull/7020)
* [Fix: deleted jobs not reflected in project synch state](https://github.com/qwcontrol/qwcontrol/pull/7018)
* [Fix: SCM job import action when both import/export are enabled can show incorrect status](https://github.com/qwcontrol/qwcontrol/pull/7017)
* [Fix: SCM Loader Fix and Sync Config Changes](https://github.com/qwcontrol/qwcontrol/pull/7015)
* [Retrieve scheduled executions without using cache](https://github.com/qwcontrol/qwcontrol/pull/6942)
* [Fix: &quot;Show all&quot; button on Jobs list is not clickable #1464](https://github.com/qwcontrol/qwcontrol/pull/6936)
* [Fix: Fix error when parsing user roles that contain commas](https://github.com/qwcontrol/qwcontrol/pull/6935)
* [Fix: Job execution through the API without Node selected by default will fail if nodes required](https://github.com/qwcontrol/qwcontrol/pull/6934)
* [Fix: Pass username to UserGroupSource script plugins](https://github.com/qwcontrol/qwcontrol/pull/6933)
* [Enh: Add indexes to Execution and LogFileStorageRequest to improve performance.](https://github.com/qwcontrol/qwcontrol/pull/6930)
* [Sec: Update lib dependency versions for bouncy castle, hibernate, jackson,…](https://github.com/qwcontrol/qwcontrol/pull/6921)
* [Fix: SCM delete nows performs a clean before deleting the configuration](https://github.com/qwcontrol/qwcontrol/pull/6913)
* [Fix:  SCM multiple issues with SCM Plugins](https://github.com/qwcontrol/qwcontrol/pull/6912)
* [Fix multiple SCM Integration Issues](https://github.com/qwcontrol/qwcontrol/pull/6908)
* [Sec: Update AWS source model plugin modules to enhance security](https://github.com/qwcontrol/qwcontrol/pull/6907)
* [Sec: Bump Jetty to 9.4.38.v20210224](https://github.com/qwcontrol/qwcontrol/pull/6867)


[Here is a link to the full list of public PRs](https://github.com/qwcontrol/qwcontrol/pulls?q=is%3Apr+milestone%3A3.3.11+is%3Aclosed)


## Contributors

* Imad Jafir (imad6639)
* Greg Schueler (gschueler)
* Luis Toledo (ltamaster)
* Rodrigo Navarro (ronaveva)
* Carlos Eduardo (carlosrfranco)
* Miguel Ramos (mishingo)
* Stephen Joyner (sjrd218)
* Greg Zapp (ProTip)
* Christopher McCarroll-Gilbert (chrismcg14)
* Forrest Evans (fdevans)


:::warning Remember!!
**For MySQL users**: Starting with QW Control `3.3.4` the MySQL JDBC driver is no longer be
bundled with the distributions. See the [Upgrade Guide](/upgrading/upgrading-to-qwcontrol-3.3.4.md)
for instructions to ensure your QW Control installation can still connect to MySQL after upgrading.
:::
