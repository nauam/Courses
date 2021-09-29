# QW Control Enterprise Licensing

## Overview

While QW Control is an open source project maintained by QW Control Inc, QW Control Enterprise is commercial software for which you can purchase a license from QW Control Inc. QW Control Enterprise provides a tested, supported, and enterprise-ready distribution of QW Control with additional features and capabilities for enterprise scale use. Also, a QW Control Enterprise subscription license is the only way to receive professional support from QW Control and the core QW Control team.

QW Control Enterprise is available under an annual subscription license and comes bundled with support. You can renew the right to use the software and receive access to support on an annual basis. Multi-year subscription purchases can also be made.

QW Control Enterprise is licensed per a combination of QW Control Enterprise clusters (consisting of two servers), any additional servers, and the number of users using QW Control Enterprise. There are no restrictions on the number of projects, nodes, or jobs run.

No software with GPL or other “copyleft” licenses are used in QW Control Enterprise. All license rights for using QW Control Enterprise are contained within the single QW Control Enterprise license.

QW Control Inc. guarantees that QW Control Enterprise does not infringe on any patents, copyrights or misappropriates any trade secrets. QW Control will defend licensees against such claims. For details, see [QW Control Enterprise Master Software License Agreement](http://support.qwcontrol.com/customer/portal/articles/2723878qwcontrolpro-license).

## License Key Installation

Ask for the license key to the support team. Then install the license key via the gui or on the filesystem directly.

### Via GUI

Upload the license key using the GUI:

![Upload the license key using the GUI](~@assets/img/license-key-gui-1.png)

Click on "No License Key File is installed"

![Click on "No License Key File is installed"](~@assets/img/license-key-gui-2.png)

Click on "Upload License File"

![Click on "Upload License File"](~@assets/img/license-key-gui-3.png)

Select the license key file and press "Upload License File"

![Agree to the QW Control Master Software License Agreement](~@assets/img/license-key-gui-3-a.png)

Agree to the QW Control Master Software License Agreement and QW Control Support Policy then click "Confirm"

![View of installed license](~@assets/img/license-key-gui-4.png)

### Via filesystem

Copy the license file to the correct directory depending of the kind of installation.

License file name : `qwcontrolpro-license.key` ( don't change to a different name )

File location:

QW Control package RPM (Redhat/centos) or DEB (debian/ubuntu):

```
/etc/qwcontrol/
```

QW Control Launcher:

```
$RDECK_BASE/etc/
```

QW Control + Tomcat:

```
$RDECK_BASE/etc/
```

### Store license in database

If you would like to store your license in your database rather than your filesystem, turn on the following setting:

`qwcontrol.license.useStorageTree=true`

If you have a license file installed in your QW Control server it will be migrated automatically into the database.

When QW Control boots it will check the license file on the filesystem if it exists, and if the issue date of
that license is more recent than the license in the database, the database will be updated with the license
on the filesystem.

### Store the license using a custom storage tree

If you would like to store your license in a storage tree, you can configure a storage tree using the standard
storage tree config options.  

Turn on license storage tree usage then provide your configuration using the prefix: `qwcontrol.license.storage`

Example storing the license in Amazon S3

```
qwcontrol.license.useStorageTree=true
qwcontrol.license.storage.provider.1.type=object
qwcontrol.license.storage.provider.1.path=/
qwcontrol.license.storage.provider.1.config.bucket=qwcontrol
qwcontrol.license.storage.provider.1.config.objectStoreUrl=https://s3.amazonaws.com
qwcontrol.license.storage.provider.1.config.accessKey=YOUR_ACCESS_KEY
qwcontrol.license.storage.provider.1.config.secretKey=YOUR_SECRET_KEY
```
