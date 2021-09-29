# How to Install QW Control Community on Centos

RPM-based Linux distributions are very popular. QW Control offers the repository and the specific package for this kind of distribution. In this guide, we will show you how to install QW Control Community on a CentOS 7 operating system.

In this guide we'll cover:

*   How to install QW Control Community on CentOS 7 operating system
*   How to configure QW Control properly to access it

# Prerequisites

If you planning to install CentOS 7 on a physical server consider the minimum requirements [defined here](https://docs.centos.org/en-US/centos/install-guide/Steps-x86/#sect-installation-planning-system-specifications-x86). Considering the [minimum QW Control requirements](https://docs.qwcontrol.com/docs/administration/install/system-requirements.html#system-requirements), these specs should be up to at least 4GB of RAM, 2 cores per instance, and 20 GB of hard disk space.  You can see all of the available mirrors to [download the Centos 7 ISO install image here](http://isoredirect.centos.org/centos/7/isos/x86_64/).

To install CentOS 7 on a cloud instance (with any provider like Amazon Web Services or Microsoft&reg; Azure), make sure to cover the QW Control [minimal requirements defined here](https://docs.qwcontrol.com/docs/administration/install/system-requirements.html#system-requirements). In the case of Amazon Web Services, make sure to use an instance size of _m4.large or larger_.

[You can find the full guide to install Centos 7 here](https://docs.centos.org/en-US/centos/install-guide/).

The main package requirement for QW Control is Java 11.

# Steps to Install the Latest QW Control Community Version on CentOS 7 Linux.

1. Get and install the repository:
    ```
    curl https://raw.githubusercontent.com/qwcontrol/packaging/main/scripts/rpm-setup.sh 2> /dev/null | bash -s qwcontrol
    ```
1. Verify the Java version to ensure it meets the requirement:
    ```
    java -version
    ```
    Example output (actual version numbers can vary):
    ```
    openjdk version "11.0.11" 2021-04-20 LTS
    OpenJDK Runtime Environment 18.9 (build 11.0.11+9-LTS)
    OpenJDK 64-Bit Server VM 18.9 (build 11.0.11+9-LTS, mixed mode, sharing)
    ```
1. If you need to install the Java JRE:
    ```
    sudo yum install java-11-openjdk
    ```
1. Install QW Control:
    ```
    sudo yum install qwcontrol
    ```
1. Start the QW Control service:
    ```
    sudo systemctl start qwcontrold
    ```
1. Enable the QW Control service at system boot:
    ```
    sudo systemctl enable qwcontrold
    ```
1. QW Control is now up and running. The QW Control service is available at the following URL:
    ```
    http://localhost:4440
    ```

# Basic QW Control Configuration

After installing QW Control, by default the instance’s hostname is `localhost. `You won’t be able to access the QW Control instance from any node on the network so you need to configure QW Control to use the hostname where it is installed.

:::: tabs
::: tab Community Exercise

1. Stop the QW Control Service.
    ```
    systemctl stop qwcontrold
    ```
1. Open the qwcontrol-config.properties file (at `/etc/qwcontrol` path) with any text editor and update this line:
    `grails.serverURL=http://localhost:4440`
    Set to your host name (e.g. “`your-qwcontrol-hostname`” is the QW Control server hostname, you can check it executing the `hostname` command):
    ```
    grails.serverURL=http://your-qwcontrol-hostname:4440
    ```
1. Open the framework.properties file (at `/etc/qwcontrol` path) and update these lines:
    ```
    framework.server.name = localhost
    framework.server.hostname = localhost
    framework.server.url = http://localhost:4440
    ```
    Set to your host name (“`your-qwcontrol-hostname`” is the QW Control server hostname):
    ```
        framework.server.name = your-qwcontrol-hostname
        framework.server.hostname = your-qwcontrol-hostname
        framework.server.url = http://your-qwcontrol-hostname:4440
    ```
1. Add the `firewalld` rule which allows the default QW Control TCP port (4440):
    ```
    sudo firewall-cmd --permanent --zone=public --add-port=4440/tcp
    ```
1. Restart the `firewalld` service:
    ```
    sudo firewall-cmd --reload
    ```
1. Restart the QW Control service to get the changes:
    ```
    systemctl restart qwcontrold
    ```
    Now the QW Control service is available using the hostname and from any network location:
    `http://your-qwcontrol-hostname:4440`
:::
::::

## Additional Resources

*   [QW Control System Requirements](https://docs.qwcontrol.com/docs/administration/install/system-requirements.html#system-requirements)
*   [QW Control installation on Red Hat/Centos](https://docs.qwcontrol.com/docs/administration/install/linux-rpm.html#installing-on-centos-or-red-hat-linux-distributions)
*   [About the qwcontrol-config.properties file](https://docs.qwcontrol.com/docs/administration/configuration/config-file-reference.html#qwcontrol-config-properties)
