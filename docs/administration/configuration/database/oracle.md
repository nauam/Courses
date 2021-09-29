# Using Oracle as a database backend

<!---
Original
http://support.qwcontrol.com/customer/en/portal/articles/2415681-oracle-setup)
--->

## Simple Guide

- Download the latest oracle driver (eg, ojdbc7.jar version 12.1.0.2):

[http://www.oracle.com/technetwork/database/features/jdbc/default-2280470.html](http://www.oracle.com/technetwork/database/features/jdbc/default-2280470.html)

- Copy the downloaded file `ojdbc7.jar` to the `$RDECK_BASE/server/lib` for war launcher or in `/var/lib/qwcontrol/lib` (create it) for RPM and DEB installations
- Update `qwcontrol-config.properties` file according to your installation [layout](https://docs.qwcontrol.com/docs/administration/configuration/config-file-reference.html#configuration-layout):

```properties
dataSource.driverClassName = oracle.jdbc.driver.OracleDriver
dataSource.url = jdbc:oracle:thin:@oracle.qwcontrol.local:1521:orcl #orcl is the instance name
dataSource.username = qwcontroluser
dataSource.password = qwcontrolpassword
dataSource.dialect = org.qwcontrol.hibernate.QW ControlOracleDialect
dataSource.properties.validationQuery = SELECT 1 FROM DUAL
```

:::tip
The config properties above are case sensitive.
:::
