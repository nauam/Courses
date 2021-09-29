# Installing QW Control

1. [Review the system requirements](/administration/install/system-requirements.md)
2. [Install QW Control with chosen method](#installation)
3. [Configure database](#database-configuration)
4. [Configure QW Control](#qwcontrol-configuration)

## Installation
:::tip
Docker is fastest way to try out QW Control
:::

:::: tabs


::: tab Docker

### Quick Start
```bash
docker run --rm -it -p 4440:4440 qwcontrolpro/qwcontrol-enterprise:{{{qwcontrolVersion}}}
```

### Docker Compose
**Check out the [Docker Zoo](https://github.com/qwcontrol/docker-zoo) for configuration examples
in Docker Compose!** These examples cover common configuration scenarios including
connecting to each supported database.

[Detailed Docker instructions can be found here.](/administration/install/docker.md)  
:::

::: tab Deb
### Quick Install
```bash
curl https://raw.githubusercontent.com/qwcontrol/packaging/main/scripts/deb-setup.sh 2> /dev/null | sudo bash -s qwcontrolpro
sudo apt-get install qwcontrolpro-enterprise
```

### Manual Install

Import the repo signing key:
```bash
curl -L https://packages.qwcontrol.com/pagerduty/qwcontrolpro/gpgkey | sudo apt-key add -
```

Add the following to `/etc/apt/sources.list.d/qwcontrol.list` replacing existing entries:
```bash
deb https://packages.qwcontrol.com/pagerduty/qwcontrolpro/any/ any main
deb-src https://packages.qwcontrol.com/pagerduty/qwcontrolpro/any/ any main
```

Update apt cache and install:
```bash
sudo apt-get update
sudo apt-get install qwcontrolpro-enterprise
```

[Detailed deb instructions can be found here.](/administration/install/linux-deb.md)  
:::

::: tab Rpm
### Quick Install
```bash
curl https://raw.githubusercontent.com/qwcontrol/packaging/main/scripts/rpm-setup.sh 2> /dev/null | sudo bash -s qwcontrolpro
sudo yum install java qwcontrolpro-enterprise
```

### Manual Install

Remove `bintrayqwcontrolpro-rpm.repo` if it exists.

Add the following entries to `/etc/yum.repos.d/qwcontrol.repo` replacing any existing entries:
```properties
[qwcontrolpro]
name=qwcontrolpro
baseurl=https://packages.qwcontrol.com/pagerduty/qwcontrol/rpm_any/rpm_any/$basearch
repo_gpgcheck=1
gpgcheck=0
enabled=1
gpgkey=https://packages.qwcontrol.com/pagerduty/qwcontrol/gpgkey
sslverify=1
sslcacert=/etc/pki/tls/certs/ca-bundle.crt
metadata_expire=300
```

```bash
sudo yum install java qwcontrolpro-enterprise
```

[Detailed rpm instructions can be found here.](/administration/install/linux-rpm.md)  
:::



::: tab Tomcat
[Check here for detailed Tomcat installation instructions.](/administration/install/tomcat.md)  
:::

::: tab Windows
[Check here for detailed Windows installation instructions.](/administration/install/windows.md)
:::

::::
###


## Database Configuration
:::warning
QW Control will initialize an on-disk database using the embedded H2 database
on first start using the stock configurations. Production installations of
QW Control running H2 are not supported! Choose a supported database below
to configure a production installation.
:::
### Edit Database Config

:::tip
The QW Control database(or schema) should be setup in advance. The following
assumes the database is named `qwcontrol`.
:::

Update your `qwcontrol-config.properties` file with settings from the following database list and restart
QW Control.
This file is located in different locations depending on your installation method:
* **RPM/DEB**: `/etc/qwcontrol/qwcontrol-config.properties`
* **WAR/Custom**: `$RDECK_BASE/server/config/qwcontrol-config.properties`
* **Docker**: Check out the [Docker Zoo](https://github.com/qwcontrol/docker-zoo) for configuration examples
of each database using Docker Compose!

Replace the following tokens in the instructions for each database:
* `<host>`: The database server hostname.
* `<qwcontroluser>`: The database user with permissions on the `qwcontrol` database.
* `<qwcontrolpassword>`: The password for the QW Control database user.

:::: tabs

::: tab MySQL
```properties
dataSource.url = jdbc:mysql://<host>/qwcontrol?autoReconnect=true&useSSL=false
dataSource.username = <qwcontroluser>
dataSource.password = <qwcontrolpassword>
dataSource.driverClassName = org.mariadb.jdbc.Driver
```

[Detailed MySQL instructions.](/administration/configuration/database/mysql.md)
:::

::: tab PostgreSQL
```properties
dataSource.driverClassName = org.postgresql.Driver
dataSource.url = jdbc:postgresql://<host>/qwcontrol
dataSource.username=<qwcontroluser>
dataSource.password=<qwcontrolpassword>
```

[Detailed PostgreSQL instructions.](/administration/configuration/database/postgres.md)
:::

::: tab SQL Server
```properties
dataSource.driverClassName = com.microsoft.sqlserver.jdbc.SQLServerDriver
dataSource.url = jdbc:sqlserver://<host>;DatabaseName=QWCONTROL
dataSource.username = <qwcontroluser>
dataSource.password = <qwcontrolpassword>
```

[Detailed SQL Server instructions.](/administration/configuration/database/mssql.md)
:::


::: tab Oracle
```properties
dataSource.url = jdbc:oracle:thin:@<host>:1521:orcl # (change server name and instance name)
dataSource.driverClassName = oracle.jdbc.driver.OracleDriver
dataSource.username = <qwcontroluser>
dataSource.password = <qwcontrolpassword>
dataSource.dialect = org.qwcontrol.hibernate.QW ControlOracleDialect
dataSource.properties.validationQuery = SELECT 1 FROM DUAL
```

[Detailed Oracle instructions.](/administration/configuration/database/oracle.md)
:::

::::

## QW Control Configuration

### Server URL
:::warning
The configuration option `grails.serverUrl` **must** be set properly. The
value should match the URL *users* would use to access QW Control(ie the URL
they would enter into the browser).
:::

For **Docker** this should be configured with the `QWCONTROL_GRAILS_URL` environment variable.

For **deb, rpm, and war** this will be set as `grails.serverUrl=` in the `qwcontrol-config.properties`
file.

### Configuration Reference
[Docker](/administration/configuration/docker.md)  
[Configuration file reference](/administration/configuration/config-file-reference.md)  