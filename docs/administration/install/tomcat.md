# QW Control as a Tomcat servlet

## Installation on Linux

<!---
Originals:

http://support.qwcontrol.com/customer/en/portal/articles/2798971-install-qwcontrol-pro-with-tomcat-on-linux
http://support.qwcontrol.com/customer/en/portal/articles/1817834-install-qwcontrol-pro-as-a-war-tomcat-on-windows
http://support.qwcontrol.com/customer/en/portal/articles/2471602-upgrade-qwcontrol-pro-as-a-war-tomcat-
http://support.qwcontrol.com/customer/en/portal/articles/2799547-enable-ssl-tomcat
http://support.qwcontrol.com/customer/en/portal/articles/2539313-jndi-custom-settings-on-tomcat)


Should these be part of the OSS docs?

http://support.qwcontrol.com/customer/en/portal/articles/2433205-configuring-tomcat-for-ldaps
http://support.qwcontrol.com/customer/en/portal/articles/2859551-authentication-with-ad-or-ldap-on-tomcat

--->

:::warning
QW Control 3.3.x requires a new system property to define the destination for your QW Control logs to be set in your Tomcat launch JAVA_OPTS.  
Ensure you have set the `qwcontrol.server.logDir` to the directory that will hold your QW Control logs. 
:::

- Install Tomcat on your environment, as a service or just using the binaries (as for this example).
- [Download](https://qwcontrol.org/downloads.html) the latest version of QW Control war file and place it in `$tomcat.base/webapps/` as e.g. qwcontrol.war
- Create `$tomcat.base/bin/setenv.sh`

```bash
$ cat setenv.sh
   JAVA_OPTS="$JAVA_OPTS -XX:MaxPermSize=512m -Xmx2048m -Xms512m -server -Drdeck.base=/path/to/qwcontrol.base -Dqwcontrol.config.location=/path/to/qwcontrol.base/server/config/qwcontrol-config.properties -Dqwcontrol.server.logDir=/path/to/qwcontrol.base/server/logs"
```

- Create `/path/to/qwcontrol.base`
- Start Tomcat
- Go to `http://localhost:8080/qwcontrol`, then at login screen: stop Tomcat
- Edit `$rdeck.base/server/config/qwcontrol-config.properties` to match Tomcat's url:

```properties
grails.serverURL=http://localhost:8080/qwcontrol
server.servlet.context-path=/qwcontrol
```

- Edit `$rdeck.base/etc/framework.properties` to match Tomcat's url:

```properties
framework.server.name = localhost
framework.server.hostname = localhost
framework.server.port = 8080
framework.server.url = http://localhost:8080/qwcontrol
```

- Start Tomcat
- Go to `http://localhost:8080/qwcontrol` and login.

## Installation on Windows

- Install Tomcat on your environment, as a service or just using the binaries (as for this example).
- [Download](https://qwcontrol.org/downloads.html) the latest version of QW Control war file and place it in `tomcat.base\\webapps\\` as e.g. qwcontrol.war
- Create `tomcat.base\\bin\\setenv.bat`

```bash
setenv.bat content:
   set "JRE_HOME=C:\Program Files\Java\jre1.8.0_181"
   set "JAVA_OPTS=-XX:MaxPermSize=512m -Xmx2048m -Xms512m -server -Drdeck.base=C:\path\to\qwcontrol.base -Dqwcontrol.config.location=C:\path\to\qwcontrol.base\server\config\qwcontrol-config.properties -Dqwcontrol.server.logDir=C:\path\to\qwcontrol.base\server\logs"
```

- Create `C:\\path\\to\\qwcontrol.base`
- Start Tomcat
- Go to `http://localhost:8080/qwcontrol`, then at login screen: stop Tomcat
- Edit `rdeck.base\\server\\config\\qwcontrol-config.properties` to match Tomcat's url:

```properties
grails.serverURL=http://localhost:8080/qwcontrol
server.contextPath=/qwcontrol
```

- Edit `rdeck.base\\etc\\framework.properties` to match Tomcat's url:

```properties
framework.server.name = localhost
framework.server.hostname = localhost
framework.server.port = 8080
framework.server.url = http://localhost:8080/qwcontrol
```

- Start Tomcat
- Go to `http://localhost:8080/qwcontrol` and login.

## Custom JNDI

### Using JNDI Resource Database Connection

This setting allow QW Control to use JNDI database connections instead of the default grails settings.

- Add the Resource link on `$tomcat.base/conf/context.xml`

```xml
  <Resource name="jdbc/qwcontroldb" auth="Container" type="javax.sql.DataSource"
               maxActive="100" maxIdle="30" maxWait="10000"
               username="qwcontroluser" password="qwcontrolpassword" driverClassName="org.mariadb.jdbc.Driver"
               url="jdbc:mariadb://mysql.qwcontrol.local:3306/qwcontrol"/>
```

- on `$qwcontrol.base/server/config/qwcontrol-config.properties` add the `dataSource.jndiName` entry:

```properties
dataSource.jndiName=java:/comp/env/jdbc/qwcontroldb
```

This will replace the dataSource.\* entries

### Using JNDI Database to manage the authentication

To use a custom authentication method using database tables:

- It is necessary to have tables like this:

```sql
create table users (
user_name varchar(15) not null primary key,
user_pass varchar(15) not null
);

create table user_roles (
user_name varchar(15) not null,
role_name varchar(15) not null,
primary key (user_name, role_name)
);

insert into users('samuel','samuel');
insert into user_roles values('samuel','user');
insert into user_roles values('samuel','admin');
```

- Define the Resource connection in `$tomcat.base/conf/server.xml`:

```xml
<!-- Global JNDI resources
      Documentation at /docs/jndi-resources-howto.html
 -->
 <GlobalNamingResources>
   <!-- Editable user database that can also be used by
        UserDatabaseRealm to authenticate users
   -->
   <Resource name="UserDatabase" auth="Container"
             type="org.apache.catalina.UserDatabase"
             description="User database that can be updated and saved"
             factory="org.apache.catalina.users.MemoryUserDatabaseFactory"
             pathname="conf/tomcat-users.xml" />

    <Resource name="jdbc/testDB"
                       auth="Container"
                       type="javax.sql.DataSource"
                       maxActive="100"
                       maxIdle="30"
                       maxWait="10000"
                       username="qwcontrolauth"
                       password="password"
                       driverClassName="com.mysql.jdbc.Driver"
                       url="jdbc:mysql://localhost:3306/userauthdb?autoReconnect=true"/>

  </GlobalNamingResources>
```

- Define the JNDI entry in `$tomcat.base/conf/server.xml`:

```xml
<!-- Use the LockOutRealm to prevent attempts to guess user passwords
     via a brute-force attack -->
<Realm className="org.apache.catalina.realm.LockOutRealm">
  <!-- This Realm uses the UserDatabase configured in the global JNDI
       resources under the key "UserDatabase".  Any edits
       that are performed against this UserDatabase are immediately
       available for use by the Realm.  -->
  <Realm className="org.apache.catalina.realm.UserDatabaseRealm"
         resourceName="UserDatabase"/>
</Realm>
 <Realm className="org.apache.catalina.realm.DataSourceRealm"
             dataSourceName="jdbc/testDB"
userTable="users"
userNameCol="user_name"
userCredCol="user_pass"
userRoleTable="user_roles"
roleNameCol="role_name"/>
```

Further information:

- [https://tomcat.apache.org/tomcat-7.0-doc/realm-howto.html#DataSourceRealm](https://tomcat.apache.org/tomcat-7.0-doc/realm-howto.html#DataSourceRealm)
- [https://tomcat.apache.org/tomcat-7.0-doc/jndi-datasource-examples-howto.html#MySQL_DBCP_Example](https://tomcat.apache.org/tomcat-7.0-doc/jndi-datasource-examples-howto.html#MySQL_DBCP_Example)

## Users authentication

Note for Linux and Windows installations: users are no longer in Tomcat's configuration files, at this point, users should be configured as in a [launcher installation](/administration/security/authentication.md#authenticating-users) and java options should be append to the setenv.sh or setenv.bat file.
