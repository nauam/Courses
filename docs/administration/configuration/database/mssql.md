# Using Microsoft&reg; SQL Server as a database backend

<!---
Original: http://support.qwcontrol.com/customer/en/portal/articles/2819414-install-qwcontrol-pro-team-launcher-on-windows
--->

Create a database on your backend, plus a user (and assign it the db_owner role)

In %RDECK_BASE%\\server\\config\\qwcontrol-config.properties, set the following:

```properties
dataSource.driverClassName = com.microsoft.sqlserver.jdbc.SQLServerDriver
dataSource.url = jdbc:sqlserver://mssql.qwcontrol.local;DatabaseName=qwcontrol
dataSource.username = qwcontroluser
dataSource.password = qwcontrolpassword
```
