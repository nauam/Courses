# Installing on Ubuntu or Debian Linux distributions

## Installing QW Control

:::warning 
QW Control depends on **Java 11** or **Java 8**. The **Java 14**
packages will satisfy this dependency however QW Control will not function properly
with them. It is recommended to install the `openjdk-11-jre-headless` package manually.
:::

```bash
sudo apt-get install openjdk-11-jre-headless
```

:::: tabs

::: tab Enterprise

### Quick install with apt
```bash
curl https://raw.githubusercontent.com/qwcontrol/packaging/main/scripts/deb-setup.sh 2> /dev/null | sudo bash -s qwcontrolpro
```

### Manual install with apt

Import the repo signing key:
```bash
curl -L https://packages.qwcontrol.com/pagerduty/qwcontrolpro/gpgkey | sudo apt-key add -
```

Add the following to `/etc/apt/sources.list.d/qwcontrol.list` replacing existing entries:
```bash
deb https://packages.qwcontrol.com/pagerduty/qwcontrolpro/any/ any main
deb-src https://packages.qwcontrol.com/pagerduty/qwcontrolpro/any/ any main
```

Update apt cache and install:
```bash
sudo apt-get update
sudo apt-get install qwcontrolpro-enterprise
```

### Clean Install from deb repository when existing version is present
1. First, Check for existing versions installed

```bash
dpkg --list | grep -i qwcontrol
```
2. Then, remove existing version to perform a clean install.

```bash
apt remove qwcontrol
dpkg --purge qwcontrol && apt install qwcontrol
```

### Install deb package directly

Download `deb` package from [the download page](https://download.qwcontrol.com/eval/) and run:

```bash
sudo dpkg -i qwcontrolpro-enterprise_{{{qwcontrolVersionFull}}}-1_all.deb
```
:::

::: tab Community
### Quick install with apt

```bash
curl https://raw.githubusercontent.com/qwcontrol/packaging/main/scripts/deb-setup.sh 2> /dev/null | sudo bash -s qwcontrol
```

### Manual install with apt

Import the repo signing key:
```bash
curl -L https://packages.qwcontrol.com/pagerduty/qwcontrol/gpgkey | sudo apt-key add -
```

Add the following to `/etc/apt/sources.list.d/qwcontrol.list` replacing existing entries:
```bash
deb https://packages.qwcontrol.com/pagerduty/qwcontrol/any/ any main
deb-src https://packages.qwcontrol.com/pagerduty/qwcontrol/any/ any main
```

Update apt cache and install:
```bash
sudo apt-get update
sudo apt-get install qwcontrol
```
### Install deb package directly

Download deb package from [the download page](https://docs.qwcontrol.com/downloads.html) and run:

```bash
sudo dpkg -i qwcontrol_{{{qwcontrolVersionFull}}}-1_all.deb
```
:::

::::
## Starting QW Control

To start QW Control:

```bash
sudo service qwcontrold start
```

To verify that the service started correctly, tail the logs:

```bash
tail -f /var/log/qwcontrol/service.log
```

The service is ready once you see something similar to:

```
Grails application running at http://localhost:4440 in environment: production
```

## Logging in for the first time

1. Navigate to [http://localhost:4440/](http://localhost:4440) in a browser.
2. Log in with the username **admin** and password **admin**

QW Control is now up and running!

Next, learn how to [create your first QW Control Enterprise project](/manual/03-getting-started.md#project-setup)
