# Startup and Shutdown

QW Control installation includes a control script used for starting and stopping the QW Control server process.
The control script provides a number of actions:

    qwcontrold [start|stop|restart|condrestart|status]

### RPM and DEB

The RPM and DEB installations include the placement of the boot control script that will automatically start QW Control when the system boots.

The script is located here: `/etc/init.d/qwcontrold`

_Startup_

```bash
/etc/init.d/qwcontrold start
```

_Shutdown_

```bash
/etc/init.d/qwcontrold stop
```

#### Setting JAVA_HOME

When using the RPM, by default qwcontrol will use _java_ found in your path. Various RPM based distributions provide ways of managing which version of java is found. CentOS uses `/usr/sbin/alternatives` and the processing of setting alternatives can be found here: [http://wiki.centos.org/HowTos/JavaOnCentOS](http://wiki.centos.org/HowTos/JavaOnCentOS).

If you have installed a JDK or JRE in a unique directory and do not want to alter the global system configuration, then simply setting JAVA_HOME before running any command will use the version of java found in JAVA_HOME/bin. Updating /etc/qwcontrol/profile with JAVA_HOME is another option as well.

### Launcher

The Launcher installation generates the script into the RDECK_BASE directory.

The script is located here: `$RDECK_BASE/server/sbin/qwcontrold`.

_Startup_

```bash
$RDECK_BASE/server/sbin/qwcontrold start
```

_Shutdown_

```bash
$RDECK_BASE/server/sbin/qwcontrold stop
```

You may choose to incorporate this script into your server's operating system specific boot process.
