# Version 2.0.0



# Release 2.0.0
===========

Date: 2014-01-31

QW Control 2.0.0 introduces a large number of major changes. We have revamped the
entire UI and overhauled the underpinnings. Our goals were to improve the user
experience and cut down some of the technical debt which had accrued.

Note that the documentation is still being updated. We will update it as it improves at <http://qwcontrol.org/2.0.0>

Before you upgrade to QW Control 2.0, please be sure to read the Upgrading Guide
located in the documentation.

Many thanks to everyone who was able to contribute ideas, feedback, code, time
or money in helping us to improve QW Control.

## Notable Changes

* New feature: live execution state view
    * Live view of job executions to see what step is running on which node.
    * Instantly drill in to view the output for the step and node that failed
    * View node metrics and collated output.
    * **Please give a big thank-you to (an anonymous) "sponsored development client" for funding the work for this feature!**
* New Projects home page displays readme and message of the day files that can be customized with markdown to display notices to users
* Improved Node filter
    * Now supports all custom node attributes
    * New filter expression syntax, simple examples:
        - `tags: a+b` filters by tags
        - `environment: (prod|qa)` Regular expression filter on an attribute called `environment`
    * New simpler UI
* Improved Nodes page to better navigate the data about the nodes in your infrastructure
    * Navigate nodes through attribute links
    * Run a job or execute a command from filter sets
* New Commands page dedicated to ad hoc command execution.
    * Controls over thread count and error handling
    * Reference saved defined filters or express your own.
* Step descriptions for workflow steps. Give your step a brief description, which will be displayed during execution.
* Improved Activity views with tabbed views for common queries
    * Tabs for Now running, recent, errors and executions by you.
* Box score metrics for executions. Use QW Control as an information radiator.
    * Percent completed and Success/Failure metrics displayed for each execution

## Enhancements

* New coat of paint: new logo, new GUI style using Bootstrap 3 and Flatly theme
* Caching and error catching for resource model source plugins
* Execution model API and json representation stored with log output
* Optimized internals to reduce service loading time
* Cruft removal (legacy formats and syntaxes), upgraded frameworks
* Copy file step plugin copies files from qwcontrol server to remote nodes.
* API
    * Better REST-ful behavior
    * removed use of 302 redirects between requests and some responses
* JDK7 support

## Related projects

The QW Control organization on github is the new location for the QW Control application source code as well as other associated projects:

* [QW Control source](https://github.com/qwcontrol/qwcontrol)
* [QW Control api-java-client library](https://github.com/qwcontrol/qwcontrol-api-java-client)
    - New version 9.3 recently released.

Additionally, the QW Control-plugin for Jenkins is now maintained by the core QW Control project maintainers.

* [QW Control-plugin for Jenkins](https://github.com/jenkinsci/qwcontrol-plugin)
    - New version 3.0 recently released

(Special thanks to Vincent Behar who originally created both the qwcontrol-api-java-client and qwcontrol-plugin projects.)

## Get in touch

Please let us know about any issues you find, or just if you like the new look:

* Github Issues: <https://github.com/dtolabs/qwcontrol/issues>
* Mailing list: <qwcontrol-discuss@googlegroups.com>
* IRC: #qwcontrol on freenode.net ([webchat link](http://webchat.freenode.net/?nick=qwcontroluser.&channels=qwcontrol&prompt=1))
* Twitter: [@qwcontrol](https://twitter.com/qwcontrol)

## Acknowledgements

* Alex Honor
* Greg Schueler
* Damon Edwards
* John Burbridge
* Moto Ohno
* Kim Ho
* Matt Wise at Nextdoor.com
* Etienne Grignon at Disney
* Srinivas Peri and Aya Ivtan at Adobe
* Mark Maun and Eddie Wizelman at Ticketmaster
* Vincent Behar
* As well as *(anonymous) Sponsored Development Clients* - thank you!

## Issues

* [Update docs for Upgrading to 2.0](https://github.com/qwcontrol/qwcontrol/issues/629)
* [Multiple node sources should merge the attributes for a node](https://github.com/qwcontrol/qwcontrol/issues/628)
* [Running QW Control in Tomcat and integrating with Jenkins ](https://github.com/qwcontrol/qwcontrol/issues/626)
* [[2.0-beta1] Execution log could not be found after renaming the job](https://github.com/qwcontrol/qwcontrol/issues/622)
* [2.0-beta1: LDAP authentication is broken for RPM install](https://github.com/qwcontrol/qwcontrol/issues/621)
* ["Change the Target Nodes" option not work in QW Control 2.0beta1](https://github.com/qwcontrol/qwcontrol/issues/619)
* [NPE parsing YAML with empty tag](https://github.com/qwcontrol/qwcontrol/issues/613)
* [named steps](https://github.com/qwcontrol/qwcontrol/issues/567)
* [Emit execution status logs via Log4j](https://github.com/qwcontrol/qwcontrol/issues/553)
* [SSH authentication in a workflow node step plugin](https://github.com/qwcontrol/qwcontrol/issues/527)
* [update qwcontrol page URLs to include project context](https://github.com/qwcontrol/qwcontrol/issues/149)

## Fixed in beta1

* [QW Control should catch errors and cache node data from Resource Model Source providers](https://github.com/dtolabs/qwcontrol/issues/609)
* [MS IE / QW Control Nodes Page: "Enter a shell command" caption not visible](https://github.com/dtolabs/qwcontrol/issues/607)
* [Refactor some execution finalization code for #511](https://github.com/dtolabs/qwcontrol/pull/604)
* [Node attributes with ":" character breaks XML serialization.](https://github.com/dtolabs/qwcontrol/issues/603)
* [Remove rpm java dependency](https://github.com/dtolabs/qwcontrol/issues/601)
* [qwcontrol does not output spaces/tabs properly](https://github.com/dtolabs/qwcontrol/issues/600)
* [edit job and duplicate to a new job buttons not-clickable in 2.0.0-1-alpha1](https://github.com/dtolabs/qwcontrol/issues/598)
* [Send Notification not saved](https://github.com/dtolabs/qwcontrol/issues/594)
* [Delete job](https://github.com/dtolabs/qwcontrol/issues/592)
* [Missing username causes failure with "Execution failed: X: null", even if project.ssh.user is set](https://github.com/dtolabs/qwcontrol/issues/589)
* [Default Option values are ignored when a jobs is referenced from another job..](https://github.com/dtolabs/qwcontrol/issues/577)
* [Remove dead/unused keys from framework.properties](https://github.com/dtolabs/qwcontrol/issues/575)
* [Remove auto-project creation from Setup](https://github.com/dtolabs/qwcontrol/issues/574)
* [The quick 'Run' page should allow for thread count adjustment as well as 'on failure' behavior changes.](https://github.com/dtolabs/qwcontrol/issues/510)
* [obsolete RDECK_HOME and rdeck.home](https://github.com/dtolabs/qwcontrol/issues/508)
* ['group' and 'user' field should be wildcard-able in the aclpolicy files](https://github.com/dtolabs/qwcontrol/issues/359)
* [upgrade grails to 2.x](https://github.com/dtolabs/qwcontrol/issues/219)
