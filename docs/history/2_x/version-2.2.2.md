# Version 2.2.2



# Release 2.2.2
=============

Date: 2014-09-19

This release fixes a number of bugs and addresses several potential security issues:

1. Require a unique token for each form request from the GUI, which prevents replay and CSRF attacks
2. Updated all pages to prevent unencoded data from being written to the response, preventing XSS style attacks.
3. Prevent access to the /api URLs via the web GUI.
4. Some plugins (Resource model, Node Executor and File Copier) now support using Password fields displayed in the Project config page. The field values once set are never revealed in clear text via the GUI.

Please see the Notes below for some configuration information
related to these changes.

**A big Thank You to one of our clients for sponsoring the work for these enhancements.**

*Security Notes:*

The new form tokens used in all form requests
by default will expire in 30 minutes.
This means that if your session timeout is larger than 30 minutes
and you attempt to e.g. run a job
after your web page has been sitting open for longer than that,
you will see an "Invalid token" error.
If this becomes a problem for you
you can either change the expiration time for these tokens,
or switch to using non-expiring tokens.
See [Administration - Configuration File Reference - Security](/administration/configuration/config-file-reference.md#security).

To add a Password field definition to your plugin,
see [Plugin Development - Description Properties](/developer/01-plugin-development.md#description-properties).
(Note that currently using property annotations is not supported
for the three plugin types that can use Password properties.)

*Upgrade notes:*

See the [Upgrading Guide](/upgrading/upgrading.md).


## Contributors

* Andreas Knifh (knifhen)
* Daniel Serodio (dserodio)
* Greg Schueler (gschueler)

## Bug Reporters

* adolfocorreia
* ahonor
* arjones85
* danpilch
* dennis-benzinger-hybris
* dserodio
* garyhodgson
* gschueler
* jerome83136
* knifhen
* majkinetor
* rfletcher
* schicky

## Issues

* [dynamic node filter string incorrectly includes name: prefix](https://github.com/qwcontrol/qwcontrol/issues/934)
* [aclpolicy files are listed in random order in Configure page](https://github.com/qwcontrol/qwcontrol/issues/931)
* [Improve "Authenticating Users" docs re. logging](https://github.com/qwcontrol/qwcontrol/pull/925)
* [Security: allow plugins to specify password properties that are obscured in project config page](https://github.com/qwcontrol/qwcontrol/pull/919)
* [Job Variable Length is too low](https://github.com/qwcontrol/qwcontrol/issues/915)
* [Config toggle: Hide error page stacktrace](https://github.com/qwcontrol/qwcontrol/pull/910)
* [Security: CSRF prevention](https://github.com/qwcontrol/qwcontrol/pull/909)
* [Security: prevent XSS issues](https://github.com/qwcontrol/qwcontrol/pull/908)
* [Cannot pass multiple values to multivalued option with enforced values](https://github.com/qwcontrol/qwcontrol/issues/907)
* [QW Control 2.1.1 scheduling bug](https://github.com/qwcontrol/qwcontrol/issues/905)
* [Selectively Disable metrics servlets features](https://github.com/qwcontrol/qwcontrol/pull/904)
* [Broken Link in Documentation](https://github.com/qwcontrol/qwcontrol/issues/903)
* [Machine tag style attributes don't get replaced ](https://github.com/qwcontrol/qwcontrol/issues/901)
* [Scheduled job with retry never completes 2.2.1](https://github.com/qwcontrol/qwcontrol/issues/900)
* [API docs state latest version is 11, but it is 12](https://github.com/qwcontrol/qwcontrol/issues/898)
* [NPE: Cannot get property 'nodeSet' on null object since upgrade to 2.2.1-1](https://github.com/qwcontrol/qwcontrol/issues/896)
* [Powershell and script-exec - extension problem](https://github.com/qwcontrol/qwcontrol/issues/894)
* [Ldap nestedGroup examples](https://github.com/qwcontrol/qwcontrol/pull/892)
* ["Retry failed nodes" does not seem to work, when using dynamic nodes filters](https://github.com/qwcontrol/qwcontrol/issues/883)
* [UI job status incorrect](https://github.com/qwcontrol/qwcontrol/issues/861)
* [Odd page when not allowing node info access](https://github.com/qwcontrol/qwcontrol/issues/844)