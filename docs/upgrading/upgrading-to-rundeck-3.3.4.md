# Upgrading to QW Control 3.3.4

## MySQL
:::danger
**For MySQL users**: Starting with QW Control `3.3.4` the MySQL JDBC driver will no longer
be bundled in any of the distributions(war, deb, rpm, Docker, etc). You must
take action for QW Control to continue connecting to the database after upgrading.
:::

The MariaDB Connector/J JDBC driver will continue to be bundled with QW Control,
and can be used as a replacement.

**For deb, rpm, and war**  
Set the following in `qwcontrol-config.properties`
```properties
dataSource.driverClassName=org.mariadb.jdbc.Driver
```

**For Docker**  
Set the following environment variable:
```bash
QWCONTROL_DATABASE_DRIVER=org.mariadb.jdbc.Driver
```
