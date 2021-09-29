# Docker Configuration Reference

:::tip
**Check out the [Docker Zoo](https://github.com/qwcontrol/docker-zoo) for configuration examples
in Docker Compose!** These examples cover common configuration scenarios including
connecting to each supported database.
:::

## Security

**Environment variables**  
Locally run jobs run as the `qwcontrol` user, the same as the server, and may carry the
environment variables used when starting the server. By default all environment variables
starting with `QWCONTROL_` are unset before starting QW Control. See `QWCONTROL_ENVARS_UNSETALL` and
`QWCONTROL_ENVARS_UNSETS` below for unset options.

## SSH Keys

You can provide private ssh keys by mounting them into `/home/qwcontrol/.ssh`:  
`$ docker run --name someqwcontrol -v /home/protip/.ssh:/home/qwcontrol/.ssh qwcontrol/qwcontrol`

**Kubernetes** users may wish to mount a private key in through the secrets system. See
Kubernetes documentation [Use-Case: Pod with ssh keys](https://kubernetes.io/docs/concepts/configuration/secret/#use-cases) for details.

[**QW Control Key Storage**](https://docs.qwcontrol.com/docs/administration/projects/node-execution/ssh.html#using-key-storage-for-ssh) can be used to provide ssh keys to the ssh plugin as well.

## Control JVM heap allocation

`$ docker run -m 1024m`

The JVM is configured to use cgroup information to set the max heap allocation size.
The RAM percentage is set to `75` by default, so the JVM will utilize up to about 3/4 the container limit.
See `JVM_MAX_RAM_PERCENTAGE` for information on changing this.

## Key Store Security
By default keystorage is set to use the database, and the encryption converters are
**disabled**. To enable encryption, supply a password for one or both of the default converters:
```
QWCONTROL_STORAGE_CONVERTER_1_CONFIG_PASSWORD=supersecret
QWCONTROL_CONFIG_STORAGE_CONVERTER_1_CONFIG_PASSWORD=supersecret
```

> **Note:** It is not recommended to enable/disable encryption after initial project setup!
Refer to the [docs](http://qwcontrol.org/docs/administration/configuration/storage-facility.html) for more information.

## User Authentication
> **NOTE:** For extra reference and clarity, refer to the official docs.
For example configurations check out the Zoo.

* [Docs](/administration/security/authentication.md#ldap)
* [Zoo](https://github.com/qwcontrol/docker-zoo/tree/master/ldap-combined)

**Default**  
The default setup utilizes the `/home/qwcontrol/server/config/realm.properties` file. Mount
or otherwise replace this file to manage further users through this method.

**JAAS**  
There is initial support for composing the JAAS modules talk about in the docks.
The convention for listing the modules to use in environment variables:
```
QWCONTROL_JAAS_MODULES_0=JettyCombinedLdapLoginModule
QWCONTROL_JAAS_MODULES_1=PropertyFileLoginModule
```

Config keys are located under:
```
QWCONTROL_JAAS_LDAP_*
QWCONTROL_JAAS_FILE_*
```

By convention the module name matches the name in the docs, and the config keys match
the config options listed in the docs uppercase, and all one word.

To configure the LDAP module as sufficient, required, requisite, optional, you can use:
```
QWCONTROL_JAAS_LDAP_FLAG
```
For further reference, please check [this documentation](/administration/security/authentication.md#multiple-authentication-modules)

## Extending Configuration

See the [Extending Configuration](/administration/configuration/docker/extending-configuration.md)
for complete details on extending the Docker application configuration.


## Environment Variables

Not all qwcontrol configuration listed in the official documentation is available for setup yet. Please take a look at the templates to see all available variables.

### Basic

`JVM_MAX_RAM_PERCENTAGE=75`

The JVM will use `x%` of the max RAM for heap. For example, a setting of `50` will cause
the JVM to utilize up to half the container limit for heap. The default is set to `75`.

`QWCONTROL_SERVER_UUID`

Identifies QW Control instances when multiple are running in the same cluster. While hard-coded
to a default for getting started, this should be set manually for more advanced configurations.

`QWCONTROL_GRAILS_URL=http://127.0.0.1:4440`

Controls the base URL the app will use for links, redirects, etc.
This is the URL users will use to access the site.

`QWCONTROL_SERVER_CONTEXTPATH=/`

Set to path QW Control is running under(i.e. `http://localhost/qwcontrol`). Useful if running QW Control
behind a reverse proxy under a path on the hostname.

`QWCONTROL_SERVER_FORWARDED=false`

Set to `true` if running behind a reverse proxy. `X-Forwarded-Proto` header must be set
if running behind a TLS terminating proxy.

`QWCONTROL_GRAILS_UPLOAD_MAXSIZE`

Controls both the `maxFileSize` and `maxRequest` for the grails controller config and `maxsize`
for the QW Control fileUploadService tempfile config.

The internal default is approximately `25Mib` or `26214400`.

`QWCONTROL_SERVER_ADDRESS=0.0.0.0`

This is the address or hostname the application will attempt to bind to within
the container.

`QWCONTROL_DATABASE_URL`

Defaults to `jdbc:h2:file:/home/qwcontrol/server/data/grailsdb;MVCC=true`. The default configuration utilizes an h2 file for data storage.

### Database

`QWCONTROL_DATABASE_DRIVER`

Set this if using an alternative backend from h2.

- `org.postgresql.Driver`
- `org.mariadb.jdbc.Driver`
- `com.mysql.jdbc.Driver` (Must download the jar.  It is not bundled with QW Control.)

`QWCONTROL_DATABASE_USERNAME`

`QWCONTROL_DATABASE_PASSWORD`

### Logging

`QWCONTROL_LOGGING_STRATEGY=CONSOLE`

The default console strategy configures log4j to send all output to stdout
to be collected by the container logging driver.

Set to `FILE` to log into `/home/qwcontrol/server/logs` .

`QWCONTROL_LOGGING_AUDIT_ENABLED`

Set to anything enables audit logging. This can be very verbose so use with caution.

### Key Storage

`QWCONTROL_STORAGE_PROVIDER_#_[[TYPE|PATH]|CONFIG_[...]]`
`QWCONTROL_STORAGE_CONVERTER_#_[[TYPE|PATH]|CONFIG_[...]]`

Configuration options for key storage providers and converts. These map to the
[Storage Facility Docs](/administration/configuration/storage-facility.md).


### Authentication

`QWCONTROL_PREAUTH_ENABLED=false`
`QWCONTROL_PREAUTH_ATTRIBUTE_NAME=REMOTE_USER_GROUPS`
`QWCONTROL_PREAUTH_DELIMITER=,`
`QWCONTROL_PREAUTH_USERNAME_HEADER=X-Forwarded-Uuid`
`QWCONTROL_PREAUTH_ROLES_HEADER=X-Forwarded-Roles`
`QWCONTROL_PREAUTH_REDIRECT_LOGOUT=false`
`QWCONTROL_PREAUTH_REDIRECT_URL=/oauth2/sign_in`
Configuration options for using the
[preauthenticated mode](/administration/security/authenticating-users.md#preauthenticated-mode).

`QWCONTROL_TOKENS_FILE`
Specify location of a static tokens file. See [configuration file reference](/administration/configuration/configuration-file-reference.md) for details.

### Security Headers

`QWCONTROL_SECURITY_HTTPHEADERS_ENABLED=true`
`QWCONTROL_SECURITY_HTTPHEADERS_PROVIDER_XCTO_ENABLED=true`
`QWCONTROL_SECURITY_HTTPHEADERS_PROVIDER_XXSSP_ENABLED=true`
`QWCONTROL_SECURITY_HTTPHEADERS_PROVIDER_XFO_ENABLED=true`
`QWCONTROL_SECURITY_HTTPHEADERS_PROVIDER_CSP_ENABLED=true`
`QWCONTROL_SECURITY_HTTPHEADERS_PROVIDER_CSP_CONFIG_INCLUDEXCSPHEADER=false`
`QWCONTROL_SECURITY_HTTPHEADERS_PROVIDER_CSP_CONFIG_INCLUDEXWKCSPHEADER=false`
`QWCONTROL_SECURITY_HTTPHEADERS_PROVIDER_CSP_CONFIG_POLICY`

Controls for CSP headers.

### Email

`QWCONTROL_MAIL_SMTP_HOST`
`QWCONTROL_MAIL_SMTP_PORT`
`QWCONTROL_MAIL_SMTP_USERNAME`
`QWCONTROL_MAIL_SMTP_PASSWORD`
`QWCONTROL_MAIL_FROM`
Default from address.
`QWCONTROL_MAIL_DEFAULT_TEMPLATE_SUBJECT`
`QWCONTROL_MAIL_DEFAULT_TEMPLATE_FILE`
`QWCONTROL_MAIL_DEFAULT_TEMPLATE_LOG_FORMATTED`

`QWCONTROL_MAIL_PROPS`
Mail properties that get passed through to Grails. For example, to use StartTLS(required by many servers including AWS SES), `["mail.smtp.starttls.enable":"true","mail.smtp.port":"587"]`.


`QWCONTROL_ENVARS_UNSETALL=true`
Unsets all environment variables starting with `QWCONTROL_` before starting QW Control. Set to `false`
to utilize the `QWCONTROL_ENVARS_UNSETS` option.

`QWCONTROL_ENVARS_UNSETS`
Set to a space-separated list of environment variables to unset before starting QW Control.

### Thread Pools

`QWCONTROL_QUARTZ_THREADPOOL_THREADCOUNT`
Set the threadCount value to the max number of threads you want to run concurrently. If not set, default to 10.

## Enterprise Environment Variables

`QWCONTROL_SERVER_TAGS`

### Authentication

`QWCONTROL_SECURITY_DBLOGIN_ENABLED`  
`QWCONTROL_SECURITY_DBLOGIN_CREATEADMINUSERANDROLES`  
`QWCONTROL_SECURITY_DBLOGIN_ADMINUSERNAME=rdadmin`  
`QWCONTROL_SECURITY_DBLOGIN_ADMINPASSWORD`  

#### Okta

`QWCONTROL_PLUGIN_OKTAGROUPSOURCE_ENABLED=false`  
`QWCONTROL_PLUGIN_OKTAGROUPSOURCE_APITOKEN`  
`QWCONTROL_PLUGIN_OKTAGROUPSOURCE_OKTAHOSTNAME`  
`QWCONTROL_PLUGIN_OKTAGROUPSOURCE_INCLUDEGROUPTYPES=APP_GROUP`  

#### SSO Options

`QWCONTROL_SECURITY_OAUTH_ENABLED=false`  
`QWCONTROL_SSO_LOGINBUTTON_ENABLED=true`  
`QWCONTROL_SSO_LOGINBUTTON_TITLE=Login With SSO`  
`QWCONTROL_SSO_LOGINBUTTON_URL=oauth/okta`  

#### OAUTH
For oauth configuration below replace `XXXX` with the provider name(ie `okta`).
See the [SSO Documentation](/administration/security/sso.md) for more information.

`QWCONTROL_SECURITY_OAUTH_XXXX_CLIENTID`
`QWCONTROL_SECURITY_OAUTH_XXXX_CLIENTSECRET`

`QWCONTROL_SECURITY_OAUTH_XXXX_ACCESSTOKENURI`
`QWCONTROL_SECURITY_OAUTH_XXXX_USERAUTHORIZATIONURI`
`QWCONTROL_SECURITY_OAUTH_XXXX_USERINFOURI`
`QWCONTROL_SECURITY_OAUTH_XXXX_JWKSETURI`

`QWCONTROL_SECURITY_OAUTH_XXXX_AUTOCONFIGURL`

`QWCONTROL_SECURITY_OAUTH_XXXX_CUSTOMREDIRECTURI`
`QWCONTROL_SECURITY_OAUTH_XXXX_AUTHORITYPROPERTY`
`QWCONTROL_SECURITY_OAUTH_XXXX_AUTHORITYKEYS`
`QWCONTROL_SECURITY_OAUTH_XXXX_AUTHORITYASCOMMASEPARATEDSTRING`
`QWCONTROL_SECURITY_OAUTH_XXXX_PRINCIPLEKEYS`
`QWCONTROL_SECURITY_OAUTH_XXXX_CLIENTAUTHENTICATIONSCHEMA`
`QWCONTROL_SECURITY_OAUTH_XXXX_SCOPE`

### Cluster

`QWCONTROL_PLUGIN_CLUSTER_HEARTBEAT_CONSIDERDEAD=180`  
`QWCONTROL_PLUGIN_CLUSTER_AUTOTAKEOVER_ENABLED=true`  
`QWCONTROL_PLUGIN_CLUSTER_AUTOTAKEOVER_POLICY=any`  
`QWCONTROL_PLUGIN_CLUSTER_AUTOTAKEOVER_CONFIG_ALLOWED`  
`QWCONTROL_PLUGIN_CLUSTER_AUTOTAKEOVER_DELAY=30`  
`QWCONTROL_PLUGIN_CLUSTER_AUTOTAKEOVER_SLEEP=30`  

`QWCONTROL_PLUGIN_CLUSTER_REMOTEEXECUTION_ENABLED=true`  
`QWCONTROL_PLUGIN_CLUSTER_REMOTEEXECUTION_POLICY=Random`  
`QWCONTROL_PLUGIN_CLUSTER_REMOTEEXECUTION_PREFERREDTAGS=*`  
`QWCONTROL_PLUGIN_CLUSTER_REMOTEEXECUTION_ACTIVEONLY=true`  

### Execution Log Storage

#### S3

`QWCONTROL_PLUGIN_EXECUTIONFILESTORAGE_NAME`  

Set to `com.qwcontrol.qwcontrolpro.amazon-s3`

`QWCONTROL_PLUGIN_EXECUTIONFILESTORAGE_S3_BUCKET`  
`QWCONTROL_PLUGIN_EXECUTIONFILESTORAGE_S3_REGION`  
`QWCONTROL_PLUGIN_EXECUTIONFILESTORAGE_S3_AWSACCESSKEYID`  
`QWCONTROL_PLUGIN_EXECUTIONFILESTORAGE_S3_AWSSECRETKEY`  
:::warning
It is recommended to use ec2 instance roles or another credential chain source if possible.
:::

`QWCONTROL_PLUGIN_EXECUTIONFILESTORAGE_S3_ENDPOINT`  
`QWCONTROL_PLUGIN_EXECUTIONFILESTORAGE_S3_PATHSTYLE=false`  
`QWCONTROL_PLUGIN_EXECUTIONFILESTORAGE_S3_ALLOWDELETE`  
