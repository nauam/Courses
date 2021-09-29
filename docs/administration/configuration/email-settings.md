# Email Settings

This document describes how to configure QW Control for email
support.
Email settings are located in the qwcontrol-config.properties file. Depending on the installer used, the configuration files will be under a base directory:

- RPM/DEB: /etc/qwcontrol/qwcontrol-config.properties
- Launcher: \$RDECK_BASE/server/config/qwcontrol-config.properties

Refer to the appropriate configuration file paths from [Configuration -> Configuration Layout](/administration/configuration/config-file-reference.md#configuration-layout) to locate the QW Control configuration paths depending on your install.

## SMTP server settings

By default the plugin assumes an unsecured mail server configured at localhost on port 25.
You can specify your own with these settings:

```properties
grails.mail.host=localhost
grails.mail.port=25
```

To add authentication:

```properties
grails.mail.username=user
grails.mail.password=pass
```

### Advanced SMTP settings

If you need more advanced configuration (e.g., authenticated and secured over SSL),
see the grails Mail plugin configuration:
[Grails Mail Configuration](https://gpc.github.io/grails-mail/guide/2.%20Configuration.html)

The caveat for using this is that in our experience it requires using a .groovy formatted configuration file to support the extended configuration properties.

See [Groovy config format](/administration/configuration/config-file-reference.md#groovy-config-format).

## Notification email settings

The URL and From: address used in [Job email notifications](/manual/creating-jobs.md#job-notifications) are managed via the settings located in the qwcontrol-config.properties file.

The two properties are:

- grails.serverURL
- grails.mail.default.from

Here's an example:

```properties
grails.serverURL=https://node.fully.qualified.domain.name:4443
grails.mail.default.from=deployer@domain.com
```

### Custom Email Templates

You can define these properties to customize the email notifications. Each property can be defined for a specific Trigger, or for the general case. Available triggers are: `success`,`failure`, and `start`. In addition, you can have custom settings for a project and job name combination as well:

```properties
# trigger-specific templating
qwcontrol.mail.[trigger].template.subject=[custom subject line]
qwcontrol.mail.[trigger].template.file=[path to template file]
qwcontrol.mail.[trigger].template.log.formatted=true/false (if true, prefix log lines with context information)

# project and job specific
qwcontrol.mail.[project].[jobname].template.subject=[custom subject line]
qwcontrol.mail.[project].[jobname].template.file=[path to template file]
qwcontrol.mail.[project].[jobname].template.log.formatted=true/false (if true, prefix log lines with context information)

# apply to any triggers not specified
qwcontrol.mail.template.subject=[Default subject line]
qwcontrol.mail.template.file=[path to template file]
qwcontrol.mail.template.log.formatted=true/false (if true, prefix log lines with context information)
```

If a template filepath ends with `.md` or `.markdown`, then it will be interpreted as a Markdown formatted template. Otherwise it is expected that the template file contains HTML.

The Subject line, filepath, and file contents can all contain embedded property references of the form `${group.key}`. The available properties are mostly the same as those available for Notification Plugins, including the `execution.*` and `job.*` values. See [Plugin Developer Guide - Notification Plugin - Execution Data](/developer/05-notification-plugins.md#execution-data).

The "Context Variables" values used within the execution are available just as they are in the execution, so options would be available as `${option.name}`.

In addition these properties are defined:

- `qwcontrol.href`: URL to the QW Control server
- `notification.trigger`: Trigger name
- `notification.eventStatus`: A string indicating the combination of execution status, and notification trigger, suitable for an email subject line, such as "KILLED", "FAILURE", "STARTING", "SUCCESS".
- `execution.projectHref`: URL to the Project within QW Control.

#### Custom Attached Log Output file

When the log output is attached as a file, the file's extension can be defined by adding new settings on rudeck-config.properties.
For example:

```properties
qwcontrol.mail.template.log.extension=html
qwcontrol.mail.template.log.contentType=text/html
```

```properties
qwcontrol.mail.<PROJECT>.<JOBNAME>.template.log.extension=csv
qwcontrol.mail.<PROJECT>.<JOBNAME>.template.log.contentType=text/csv
```

```properties
qwcontrol.mail.<TRIGGER>.template.log.extension=html
qwcontrol.mail.<TRIGGER>.template.log.contentType=text/html
```

## Troubleshooting

See the [service.log](/administration/maintenance/logs.md#service.log) for mail error messages.
