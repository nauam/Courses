# System Requirements

The following operating systems are known to support QW Control:

- Linux: Most recent distributions are likely to work
- Windows: XP, Server and above
- Mac OS X 10.4 or later

Root (or Administrator on Windows) is not required or recommended. We
recommend using a dedicated user account such as "qwcontrol".

If there is need for root access, please set up the QW Control user
to have access via [sudo].

[sudo]: https://en.wikipedia.org/wiki/Sudo

- **Supported Operating Systems:**
  - Red Hat Enterprise Linux
  - Oracle Linux
  - CentOS
  - Debian
  - Ubuntu
  - Windows Server
- **[JAVA](#java) 8 or 11 Installed.**
- **2 CPUs**
  - 2 CPUs per instance
- **4 GB RAM**
- **20 GB hard disk**
- **Database**
  - Mysql version
  - Mariadb version
  - Postgres version
  - Oracle version
- **Log store**
  - File system
  - S3 compatible object store
- **Amazon EC2**
  - Instance size of m3.medium or larger
  - An instance size of m3.xlarge or larger if there are more than 100 hosts
- **Accessing QW Control requires a currently supported version of Mozilla Firefox or Google Chrome**
  - \* Other HTML5 compliant web browsers may work but are not fully tested or supported.

### Java

QW Control is a Java-Servlet based server and therefore requires the Java runtime.

As of version 3.3.0 QW Control supports either Java 8 or Java 11.  Java must be installed prior to running the install process. [Open JDK](http://openjdk.java.net/) and [Sun/Oracle](https://java.com/) JVMs are supported.
Ensure the JAVA_HOME environment variable defined in your environment before running the launcher. The RPM will use the java found on your path. See [Setting JAVA_HOME](/administration/maintenance/startup.md#setting-java_home) if you want to run a different version of java.

Verify your Java version to check it meets the requirement:

```bash
$ java -version
```
Example output (actual version numbers can vary)

```
java version "1.8.0_131"
Java(TM) SE Runtime Environment (build 1.8.0_131-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.131-b11, mixed mode)
```
_or_
```
java version "11.0.7" 2020-04-14 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.7+8-LTS)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.7+8-LTS, mixed mode)
```

:::tip
Note: QW Control versions 3.2.x only run on Java 1.8
:::

### Network access

When the server starts, it binds to several TCP ports by default:

- 4440 (http)
- 4443 (https)

To check if the ports are free on a Unix host, run:

```bash
$ netstat -an | egrep '4440|4443'
```

If the ports are in use on the server, you will see output similar to below:

    tcp46      0      0  *.4440                 *.*                    LISTEN

The installation procedures describe how to choose different ports, if
there is a conflict.

In addition, TCP port 22 (by default) needs to be open on the clients for SSH.

Clients should be set up to allow the QW Control server user to connect to
the clients using SSH via public-key authentication. It should not
prompt for a password. See
[Configure remote machine for SSH](/administration/projects/node-execution/ssh.md#configuring-remote-machine-for-ssh)
in the Administration chapter.

There are various ways for installing SSH on Windows; we recommend
[Cygwin].

[cygwin]: https://www.cygwin.com/

### Database

When you install the vanilla standalone qwcontrol configuration, it will use H2, an embedded database.
It is convenient to have an embedded database when you are just trying QW Control or using it for a non-critical purpose. Be aware though that using the H2 database is not considered safe for production because it not reslilient if QW Control is not shutdown gracefully. When shutdown gracefully, QW Control can write the data (kept in memory) to disk. If QW Control is forcefully shutdown, the data can not be guaranteed to be written to file on disk and cause truncation and corruption.

Don't use the H2 embedded database for anything except testing and non-production.

Use an external database service like Mariadb, Mysql, Posgres or Oracle.

Also, be sure to locate your external database on a host(s) with sufficient capacity and performance. Don't create a downstream bottleneck!

For more about setting the datasource see: [Configuration/Database](/administration/configuration/database/index.md).

### Logstore

QW Control records all job execution data into the Logstore. By default, QW Control is configured to use the local file system. Normally, that is defined by the `framework.logs.dir` system setting found in framework.properties.

If you are setting up a clustered QW Control see: [Configuration/Logstore](/administration/cluster/logstore/index.md).
