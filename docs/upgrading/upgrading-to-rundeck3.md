# Upgrade QW Control 2.11.X to QW Control 3.X

Updated June 1, 2018

## QW Control Launcher

The "launcher jar" for QW Control 2 is gone. However, the .war file now operates the same way. Just use the .war in the same way as the previous launcher jar, or deploy it as a webapp.

To upgrade to QW Control 3 using launcher use the following steps:

**NOTE: replace `$RDECK_BASE` below with the real path.**

* Stop QW Control Service, eg: `$RDECK_BASE/server/sbin/qwcontrold stop`
* In case you have customs plugins in `libext` folder, backup them. For example, you can move the full `libext`:
  ```sh
  mv $RDECK_BASE/libext $RDECK_BASE/libext.2-11
  ```
* Remove previous "source" folders:
  ```sh
  rm -rf $RDECK_BASE/server/exp/ $RDECK_BASE/server/lib/ $RDECK_BASE/server/sbin/ $RDECK_BASE/tools/
  ```
* Copy the new war file to `$RDECK_BASE` and install it:
  ```sh
  java -jar qwcontrol-3.X.war --installonly
  ```
* Add the following attribute to `$RDECK_BASE/server/config/qwcontrol-config.properties`
  ```properties
  qwcontrol.log4j.config.file = $RDECK_BASE/server/config/log4j.properties
  ```
* Copy the "custom" plugins back to `$RDECK_BASE/libext` folder
* Start qwcontrol 3: `$RDECK_BASE/server/sbin/qwcontrold start`

## QW Control DEB Package

The upgrade process can be done using the `.deb` file or using the command `apt-get`:

**If using deb package**

```sh
sudo dpkg -i qwcontrol-3.0.X.deb
```

**If using apt-get**

```sh
sudo apt-get upgrade qwcontrol
```

**Configuration Files:**

When the upgrade command is run, the upgrade process will prompt about what to do with the new version of config files. In the case of `qwcontrol-config.properties`, a merge needs to be done between the old and new version, because the attribute `qwcontrol.log4j.config.file` is needed on QW Control 3 (this attribute is part of the default `qwcontrol-config.properties` template):

```
Configuration file '/etc/qwcontrol/qwcontrol-config.properties'
 ==> Modified (by you or by a script) since installation.
 ==> Package distributor has shipped an updated version.
   What would you like to do about it ?  Your options are:
    Y or I  : install the package maintainer's version
    N or O  : keep your currently-installed version
      D     : show the differences between the versions
      Z     : start a shell to examine the situation
 The default action is to keep your current version.
*** qwcontrol-config.properties (Y/I/N/O/D/Z) [default=N] ?
```

For example, if you select "YES" the older file will be moved to `qwcontrol-config.properties.dpkg-old`, and `qwcontrol-config.properties` will be loaded with the default values (so a merge will be needed)

```
-rw-r----- 1 qwcontrol qwcontrol  986 May 11 19:13 realm.properties
-rw-r----- 1 qwcontrol qwcontrol  730 May 11 19:13 project.properties
-rw-r----- 1 qwcontrol qwcontrol 7529 May 11 19:13 log4j.properties
-rw-r----- 1 qwcontrol qwcontrol  136 May 11 19:13 jaas-loginmodule.conf
-rw-r----- 1 qwcontrol qwcontrol 1104 May 11 19:13 apitoken.aclpolicy
-rw-r----- 1 qwcontrol qwcontrol  738 May 11 19:13 admin.aclpolicy
-rw-r----- 1 qwcontrol qwcontrol 1438 Jun  1 19:28 framework.properties
-rw-r----- 1 qwcontrol qwcontrol  454 Jun  1 19:32 qwcontrol-config.properties
-rw-r----- 1 qwcontrol qwcontrol 3419 Jun  1 19:32 profile
-rw-r----- 1 qwcontrol qwcontrol  511 Jun  1 19:32 cli-log4j.properties
-rw-r----- 1 qwcontrol qwcontrol  673 Jun  4 14:22 qwcontrol-config.properties.dpkg-old
drwxr-x--- 1 qwcontrol qwcontrol 4096 Jun  4 14:25 ssl
```

A restart is necessary after the merge of `qwcontrol-config.properties`

## QW Control RPM Package

The upgrade process can be done using the `.rpm` file or using the command `yum`:

### Using rpm package

```sh
# rpm -U qwcontrol-3.x.rpm qwcontrol-config-3.X.rpm

warning: /etc/qwcontrol/framework.properties created as /etc/qwcontrol/framework.properties.rpmnew
warning: /etc/qwcontrol/qwcontrol-config.properties created as /etc/qwcontrol/qwcontrol-config.properties.rpmnew
qwcontrol.server.uuid = XXXXXXXXXXXXXXX

```

### Using yum

```sh
# yum upgrade qwcontrol qwcontrol-config
```

In the case of the RPM upgrade, the old properties files are not modified, and the new files are saved with the extension `.rpmnew`. For the configuration file `qwcontrol-config.properties` a merge is needed to include new default attribute (`qwcontrol.log4j.config.file`).

```sh
# ls -lrt
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

If the `profile` file was modified on 2.11.x, the new profile file (for 3.x) will be created with the name `profile.rpmnew`. If that is the case, merge the changes on the old file and move them to the new one, eg:

```sh
# mv /etc/qwcontrol/profile.rpmnew /etc/qwcontrol/profile
```

A restart is necessary after the merge of `qwcontrol-config.properties` or/and `profile` file.

## Tomcat War deployment

- Stop Tomcat
- Delete `$tomcat.base/webapps/qwcontrol`
- Delete `$tomcat.base/webapps/qwcontrol.war`
- Place QW Control 3 as the old war file `$tomcat.base/webapps/qwcontrol.war`
- Remove `$rdeck.base/var/.install_complete` and `$rdeck.base/var/.install_complete-missing-ver` if any.
- In case you have customs plugins in `libext` folder, backup them. For example, you can move the full libext:
  ```sh
  mv $rdeck.base/libext $rdeck.base/libext.2-11
  ```
- Start Tomcat
- Copy the "custom" plugins back to `$rdeck.base/libext` folder.

### NOTES FOR TOMCAT:

- Due to changes in authentication, `tomcat-users.xml` and other Tomcat's authentication modules no longer work, you should configure users as in a [launcher installation](/administration/security/authentication.md#authenticating-users).

- If you do not have "-Dqwcontrol.config.location" defined or configured in `$tomcat.base/bin/setenv.sh` file (`tomcat.base\bin\setenv.bat` for Windows), it will take `$rdeck.base/server/config/qwcontrol-config.properties`.
