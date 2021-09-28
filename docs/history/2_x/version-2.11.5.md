# Version 2.11.5



# Release 2.11.5
===========

Date: 2018-07-06

Name: <span style="color: SeaGreen"><span class="glyphicon glyphicon-tower"></span> "cappuccino seagreen tower"</span>

## Upgrading from Earlier versions

* See the [Upgrading Guide](http://rundeck.org/docs/upgrading/index.html)

## Notes

Bug fixes.

This release addresses the error **ORA-01795** in `menu/home` when using Oracle
Database with over 1000 projects.

## Contributors

* Jaime Tobar (jtobard)

## Bug Reporters

* isuftin
* jtobard
* sebastianbello

## Issues

[Milestone 2.11.5](https://github.com/rundeck/rundeck/milestone/79)

* ["Cannot get property 'extid' on null object" when viewing job definition](https://github.com/rundeck/rundeck/issues/3474)
* [NPE on referenced Job](https://github.com/rundeck/rundeck/pull/3655)
* [Error message:  ORA-01795: maximum number of expressions in a list is 1000](https://github.com/rundeck/rundeck/issues/3526)
* [Fix Error message: ORA-01795](https://github.com/rundeck/rundeck/pull/3650)