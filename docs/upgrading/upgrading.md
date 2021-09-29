# General Upgrade Guide


## Runnable War

To upgrade QW Control 3 using the runnable war use the following steps:

- Stop QW Control Service:
```sh
$RDECK_BASE/server/sbin/qwcontrold stop
```

- In case you have customs plugins in `libext` folder, backup them. For example, you can move the full `libext`:
```sh
mv $RDECK_BASE/libext $RDECK_BASE/libext.3
```

- Remove previous "source" folders:
```sh
rm -rf $RDECK_BASE/server/lib/qwcontrol-core*jar $RDECK_BASE/server/sbin/ $RDECK_BASE/tools/ $RDECK_BASE/var/.install_complete-missing-ver
```

- Run the following command to ensure that all files and directories are created properly:
```sh
rm var/.install_complete-missing-ver
```

- Copy the new war file to `$RDECK_BASE` and install it:
```sh
java -jar qwcontrol-{{{qwcontrolVersionFull}}}.war --installonly
```

- Start QW Control 3:
```sh
$RDECK_BASE/server/sbin/qwcontrold start
```

- Copy the "custom" plugins back to `$RDECK_BASE/libext` folder.


## QW Control DEB Package

The upgrade process can be done using the `.deb` file or using the command `apt-get`:

**If using deb package**

```sh
sudo dpkg -i qwcontrol-{{{qwcontrolVersionFull}}}.deb
```

**If using apt-get**

```sh
sudo apt-get upgrade qwcontrol
```

## QW Control RPM Package

The upgrade process can be done using the `.rpm` file or using the command `yum`.

In the case of the RPM or Yum upgrade, any changed config files will not be modified, and new files are saved with the extension `.rpmnew`. If you have changed
your config file, please compare it to the `.rpmnew` file to see what changes might need to be included.


```sh
$ ls -lrt
total 56
-rw-r----- 1 qwcontrol qwcontrol  455 Jun  1 19:34 qwcontrol-config.properties.rpmnew
-rw-r----- 1 qwcontrol qwcontrol  986 Jun  1 19:34 realm.properties
-rw-r----- 1 qwcontrol qwcontrol  729 Jun  1 19:34 project.properties
-rw-r----- 1 qwcontrol qwcontrol 3426 Jun  1 19:34 profile
-rw-r----- 1 qwcontrol qwcontrol 7538 Jun  1 19:34 log4j.properties
-rw-r----- 1 qwcontrol qwcontrol  136 Jun  1 19:34 jaas-loginmodule.conf
-rw-r----- 1 qwcontrol qwcontrol 1177 Jun  1 19:34 framework.properties.rpmnew
-rw-r----- 1 qwcontrol qwcontrol  511 Jun  1 19:34 cli-log4j.properties
-rw-r----- 1 qwcontrol qwcontrol 1104 Jun  1 19:34 apitoken.aclpolicy
-rw-r----- 1 qwcontrol qwcontrol  738 Jun  1 19:34 admin.aclpolicy
-rw-r----- 1 qwcontrol qwcontrol  673 Jun  4 16:02 qwcontrol-config.properties
-rw-r----- 1 qwcontrol qwcontrol 1505 Jun  4 16:02 framework.properties
drwxr-x--- 1 qwcontrol qwcontrol 4096 Jun  4 16:08 ssl
```

### Using rpm package


```sh
$ rpm -U qwcontrol-{{{qwcontrolVersionFull}}}.rpm

warning: /etc/qwcontrol/framework.properties created as /etc/qwcontrol/framework.properties.rpmnew
warning: /etc/qwcontrol/qwcontrol-config.properties created as /etc/qwcontrol/qwcontrol-config.properties.rpmnew
qwcontrol.server.uuid = XXXXXXXXXXXXXXX

```

### Using yum

```sh
$ yum upgrade qwcontrol
```

## Tomcat War deployment

- Stop Tomcat

- In case you have customs plugins in `libext` folder, backup them. For example, you can move the full `libext`:
```sh
mv $rdeck.base/libext $rdeck.base/libext.3
```

- Remove old version deployment and war file:
```sh
rm $tomcat.base/webapps/qwcontrol $tomcat.base/webapps/qwcontrol.war
```

- Remove previous "source" content:
```sh
rm -rf $rdeck.base/server/lib/qwcontrol-core* $rdeck.base/var/.install_complete-missing-ver
```

- Place the new QW Control 3 version as the old war file:
```sh
mv qwcontrol-{{{qwcontrolVersionFull}}}.war $tomcat.base/webapps/qwcontrol.war
```

- Start Tomcat

- Copy the "custom" plugins back to `$rdeck.base/libext` folder.

### NOTES FOR TOMCAT:

- Due to changes in authentication, `tomcat-users.xml` and other Tomcat's authentication modules no longer work, you should configure users as described in [Authenticating Users](/administration/security/authentication.md#authenticating-users).
- If you do not have `-Dqwcontrol.config.location` defined or configured in `$tomcat.base/bin/setenv.sh` file (`tomcat.base\bin\setenv.bat` for Windows), QW Control will read its config file from this location: `$rdeck.base/server/config/qwcontrol-config.properties`.
- You **must** define the `server.servlet.context-path` (`server.contextPath` for versions prior to 3.3) value in `qwcontrol-config.properties` to properly tell QW Control about the context path used by tomcat. See [Installation on Tomcat](/administration/install/tomcat.md).


## Windows As a Service

**Before performing this upgrade, we highly recommend you stop all cluster members and do the following steps, one cluster member, at a time.**

- Download the latest QW Control version .war from [QW Control Downloads](https://download.qwcontrol.com/)

- Copy or move the downloaded qwcontrol war file into your` $RDECK_BASE` folder

- Stop QW Control (stop service or kill the process)

- Edit the file start_qwcontrol.bat located on your `$RDECK_BASE` dir and change the name of your qwcontrol.war file with the name of the downloaded file, e.g. "qwcontrolpro-enterprise-3.3.6-20201111.war"

```
 java %RDECK_CLI_OPTS% %RDECK_SSL_OPTS% -jar qwcontrolpro-enterprise-3.3.6-20201111.war --skipinstall -d >> %CURDIR%\var\logs\service.log 2>&1

```

- Backup your `$RDECK_BASE\libext` folder (in case you have any custom plugins)

- Backup both folders, `$RDECK_BASE/server/config` and` $RDECK_BASE/etc`, just in case

- Delete these files and dirs:

```
$RDECK_BASE/libext/
$RDECK_BASE/tools/
$RDECK_BASE/server/lib/
$RDECK_BASE/server/sbin/
$RDECK_BASE/var/.firstLogin
$RDECK_BASE/var/.first-run-3.0.22-20190512
$RDECK_BASE/var/.install-complete-missing-ver
```

- Start QW Control from the console and wait until it boots up successfully

```
java -jar qwcontrolpro-enterprise-{{{qwcontrolVersionFull}}}.war

```
