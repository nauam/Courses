# Release 3.2.2

Name: <span style="color: brown"><span class="glyphicon glyphicon-leaf"></span> "nacho brown leaf"</span>

## Upgrading
See [Upgrading to QW Control 3.2](/upgrading/upgrading-to-qwcontrol-3.2.html).


## Issues

[Milestone 3.2.2](https://github.com/qwcontrol/qwcontrol/milestone/133)

* [Fixes #5761 by adding scheduled true to the dynamic finder.](https://github.com/qwcontrol/qwcontrol/pull/5769)
* [Fix wrong job scheduled status message in jobs list](https://github.com/qwcontrol/qwcontrol/pull/5764)
* [Add underscore to project description regex.](https://github.com/qwcontrol/qwcontrol/pull/5755)
* [Fix #5753 - An error message needs to be shown on GUI when deleting the project returns an error](https://github.com/qwcontrol/qwcontrol/pull/5754)
* [Fixes Activity Filter Doesn't Save in Search Modal](https://github.com/qwcontrol/qwcontrol/pull/5752)
* [Fixing a n+1 issue removing a code that accessed the list of executions and was making a query for each one. ](https://github.com/qwcontrol/qwcontrol/pull/5749)
* [Fix for problem validating remote url options using other options values. 5733](https://github.com/qwcontrol/qwcontrol/pull/5748)
* [Fix #5721 by setting the form name to the correct value for the avg duration url.](https://github.com/qwcontrol/qwcontrol/pull/5742)
* [ Changing the mechanism that loads the plugins into memory to consider the type of the plugin in addition to its name](https://github.com/qwcontrol/qwcontrol/pull/5737)
* [JobsAjax causing QW Control to become unresponsive](https://github.com/qwcontrol/qwcontrol/issues/5735)
* [Enforced from Allowed Values fails  when option value is used in Remote URL (persists)](https://github.com/qwcontrol/qwcontrol/issues/5733)
* [Job query internal extension](https://github.com/qwcontrol/qwcontrol/pull/5720)
* [Defining a default value for crontabString prop when field is empty. ](https://github.com/qwcontrol/qwcontrol/pull/5710)
* [Bug/3922/jobs incorrect cursors](https://github.com/qwcontrol/qwcontrol/pull/5708)
* [Fix copy paste err message issue in UserService.](https://github.com/qwcontrol/qwcontrol/pull/5706)
* [Allow valid unicode characters in user first and last name fields](https://github.com/qwcontrol/qwcontrol/pull/5705)
* [Bug in UserService registerLogin](https://github.com/qwcontrol/qwcontrol/issues/5704)
* [Upgrade snakeyaml](https://github.com/qwcontrol/qwcontrol/pull/5703)
* [Upload plugin artifact to private repository fails](https://github.com/qwcontrol/qwcontrol/issues/5702)
* [search activity filter save](https://github.com/qwcontrol/qwcontrol/issues/5692)
* [expanding execution variables on notification plugin config](https://github.com/qwcontrol/qwcontrol/pull/5689)
* [scm git plugin: close repo and delete using recursive flag on cleanup](https://github.com/qwcontrol/qwcontrol/pull/5688)
* [FIX: typo in spanish translation](https://github.com/qwcontrol/qwcontrol/pull/5681)
* [Problem creating a new Project with Execution History Clean](https://github.com/qwcontrol/qwcontrol/issues/5679)
* [Notification doesn't expand execution context variables on notification plugins](https://github.com/qwcontrol/qwcontrol/issues/5674)
* [Fix webhook checkbox label should work](https://github.com/qwcontrol/qwcontrol/pull/5673)
* [upgrade openssh plugin ](https://github.com/qwcontrol/qwcontrol/pull/5666)
* [update jgit to 5.6.0.201912101111-r](https://github.com/qwcontrol/qwcontrol/pull/5658)
* [Bump handlebars from 4.1.2 to 4.5.3 in /qwcontrolapp/grails-spa](https://github.com/qwcontrol/qwcontrol/pull/5657)
* [Adds example for audit plugin](https://github.com/qwcontrol/qwcontrol/pull/5594)
* [ssh export rd variables](https://github.com/qwcontrol/qwcontrol/pull/5577)
* [Bump external-config from 1.1.2 to 1.3.0](https://github.com/qwcontrol/qwcontrol/pull/4860)
* [QW Control 3 : Selection cursor](https://github.com/qwcontrol/qwcontrol/issues/3922)

## Contributors

* Alberto Hormazabal C (ahormazabal)
* Greg Schueler (gschueler)
* Jaime Tobar (jtobard)
* Jesse Marple (jessemarple)
* Luis Toledo (ltamaster)
* Luke Swithenbank (lswith)
* Stephen Joyner (sjrd218)
* carlosrfranco
* jairov4
* ronaveva

## Bug Reporters

* Ehoudry
* ProTip
* ahormazabal
* carlosrfranco
* gschueler
* jairov4
* jessemarple
* jplassnibatt
* jtobard
* lswith
* ltamaster
* ronaveva
* sebastianbello
* sjrd218
