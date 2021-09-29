# Installing on Windows

### Prerequisites

Before proceeding to install QW Control, check all system [requirements](https://docs.qwcontrol.com/docs/administration/install/system-requirements.html) to make sure that the server can run QW Control, also, make sure that the Windows user has sufficient rights to install software.

Be sure to install the appropriate Java Software Development Kit per the [requirements](https://docs.qwcontrol.com/docs/administration/install/system-requirements.html).

### Installing QW Control on Windows based systems and first run

Download the QW Control WAR file and save it to a main working directory, e.g. `C:\qwcontrol`, you can download [Community](https://www.qwcontrol.com/open-source/download) version or [Enterprise](https://download.qwcontrol.com/). Set the QW Control path environment variable, by typing the following command at a Powershell command prompt :

```powershell
set RDECK_BASE=C:\qwcontrol
```

When QW Control is started for the first time, it generates the configuration files and folders structure. Open a Powershell command prompt, go to `c:\qwcontrol`, and execute
for Enterprise:

```
java -jar qwcontrolpro-enterprise-{{{qwcontrolVersionFull}}}.war
```

or this for the community edition:

```
java -jar qwcontrol-{{{qwcontrolVersionFull}}}.war
```

This step may take up to 1-2 minutes depending on system performance. When QW Control is ready, it will be indicated in the Powershell window:

![Windows launcher](~@assets/img/windows-launcher.png)

After generation is complete, stop the process with `<Crtl+C>` keys and continue with configuration.

## Folder Structure

```
+---etc
|       admin.aclpolicy => Administrator access control policy defined with a [aclpolicy] document.
|       apitoken.aclpolicy => Default API ACL policies.
|       cli-log4j.properties => This file defines the logging configuration for the Commandline tools.
|       framework.properties => Configuration file used by shell tools and core QW Control services.
|       preferences.properties
|       profile
|       profile.bat => Shell environment variables used by the shell tools.
|       project.properties =>QW Control project configuration file when using Filsystem based project defintions.
+---libext => Plugin folder.
+---projects => Projects data (eg: resource files, project properties, etc)
+---server
|   +---config
|   |       jaas-loginmodule.conf
|   |       log4j.properties => This file defines the logging configuration for qwcontrol.
|   |       realm.properties => Property file user directory when PropertyFileLoginModule is used.
|   |       qwcontrol-config.properties => This is the primary QW Control webapp configuration file. Defines default loglevel, datasource configuration, and GUI customization.
|   |       ssl.properties => To enable SSL access to qwcontrol.
|   +---data => H2 default database
|   |       grailsdb.mv.db
|   +---lib
|   |       qwcontrol-core-3.0.X.jar => qwcontrol core
|   +---logs => QW Control logging
|   |       qwcontrol.access.log => access to qwcontrol.
|   |       qwcontrol.api.log => API calls
|   |       qwcontrol.audit.log => Authorization messages pertaining to aclpolicy.
|   |       qwcontrol.executions.log => Logs of all executions.
|   |       qwcontrol.jobs.log => Log of all job definition changes.
|   |       qwcontrol.log=> General QW Control application messages.
|   |       qwcontrol.options.log=> Logs remote HTTP requests for Options JSON data.
|   |       qwcontrol.project.log
|   |       qwcontrol.storage.log=> Standard input and output generated during runtime.
|   +---sbin
|   \---work
+---tools=> rd-acl client (to manage ACL validation).
\---var   => Executions Logs folder.
```

### Configuring QW Control

After installing QW Control, the first run and know the files/folders structure, you need to configure it. Basically publish QW Control to be available on the network and generate a .bat script to launch QW Control and use some parameters depending on our needs.

To publish QW Control to be available in your network, open `C:\qwcontrol\server\config\qwcontrol-config.properties` with your favorite text editor and change this line:

```properties
server.address=yourhostname
```

to:

```properties
server.address=0.0.0.0
```

Create a file called `start_qwcontrol.bat` with your favorite text editor with the contents shown below. Make sure the .war filename matches the war file you downloaded:

QW Control Enterprise version:

```batch
set CURDIR=%~dp0
call %CURDIR%etc\profile.bat
java %RDECK_CLI_OPTS% %RDECK_SSL_OPTS% -jar qwcontrolpro-enterprise-{{{qwcontrolVersionFull}}}.war --skipinstall -d  >> %CURDIR%\var\logs\service.log  2>&1
```

for community:

```batch
set CURDIR=%~dp0
call %CURDIR%etc\profile.bat
java %RDECK_CLI_OPTS% %RDECK_SSL_OPTS% -jar qwcontrol-{{{qwcontrolVersionFull}}}.war --skipinstall -d  >> %CURDIR%\var\logs\service.log  2>&1
```



To launch, type start_qwcontrol.bat at the command prompt. To stop QW Control, you can press `<Crtl+C>` keys.

### Login to the GUI

By default, QW Control will be available on TCP port 4440. To access, go to the following URL on your web browser: `http://servername:4440` (when "servername" is the name of your Windows server).

![Login page](~@assets/img/login-page.png)

The default username and password is "admin".

### Run QW Control as a Service

This section will install QW Control as a Windows Service so it runs in the background even when a user is not logged in.

- [Install](#installing-qwcontrol-on-windows-systems-and-first-run) QW Control.
- Download [nssm.exe](http://nssm.cc/)
- Place the executable under `%RDECK_BASE%` (you can place it elsewhere, but for the sake of the example, use this base dir)
- Open a prompt and type these commands (Administrator user is required to install a service)

```batch
    cd C:\qwcontrol
    nssm.exe install QWCONTROL
```

- The GUI pops up, set "path" as `%RDECK_BASE%\start_qwcontrol.bat`, startup directory as `%RDECK_BASE%` (optionally set "low" on the process tab, under priority, to avoid server CPU spiking when starting QW Control)

![NSSM Installer](~@assets/img/nssm-installer.png)

- Go to the Windows Service Management Console (services.msc) to start the `qwcontrol` service. You can also stop or restart QW Control here.

![Service Management Console](~@assets/img/service-management-console.png)

- set JVM memory heap on `%RDECK_BASE%\etc\profile.bat`.

Replace the `RDECK_CLI_OPTS` variable with the amount of memory that you need, for example:

```batch
....

set RDECK_CLI_OPTS=-Xms1024m -Xmx4096m
set RD_LIBDIR=%RDECK_BASE%\tools\lib
```

Now, QW Control is configured as a Service and will automatically start when Windows starts.
