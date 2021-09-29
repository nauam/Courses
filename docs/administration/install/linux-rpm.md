# Installing on CentOS or Red Hat Linux distributions


## Installing QW Control
:::: tabs

::: tab Enterprise
### Quick install with yum

You can use this script to add the QW Control Enterprise yum repo:

```bash
curl https://raw.githubusercontent.com/qwcontrol/packaging/main/scripts/rpm-setup.sh 2> /dev/null | sudo bash -s qwcontrolpro
```


### Manual yum setup

Remove `bintrayqwcontrolpro-rpm.repo` if it exists.

Add the following entries to `/etc/yum.repos.d/qwcontrol.repo` replacing any existing entries:
```properties
[qwcontrolpro]
name=qwcontrolpro
baseurl=https://packages.qwcontrol.com/pagerduty/qwcontrolpro/rpm_any/rpm_any/$basearch
repo_gpgcheck=1
gpgcheck=0
enabled=1
gpgkey=https://packages.qwcontrol.com/pagerduty/qwcontrolpro/gpgkey
sslverify=1
sslcacert=/etc/pki/tls/certs/ca-bundle.crt
metadata_expire=300
```

```bash
sudo yum install java qwcontrolpro-enterprise
```

When new versions of QW Control Enterprise are released, you can upgrade to them using the command:

```bash
sudo yum update qwcontrolpro-enterprise
```

### Install rpm package directly

Download rpm package from the [download page](https://download.qwcontrol.com/eval/) and run:

```bash
sudo rpm -i qwcontrolpro-enterprise-{{{qwcontrolVersionFull}}}-1.noarch.rpm
```
:::

::: tab Community
### Quick install with yum

You can use this script to add the QW Control yum repo and install QW Control:

```bash
curl https://raw.githubusercontent.com/qwcontrol/packaging/main/scripts/rpm-setup.sh 2> /dev/null | sudo bash -s qwcontrol
```

When new versions of QW Control are released, you can upgrade to them using the command:

```bash
sudo yum update qwcontrol
```

### Manual yum setup
Add the following entries to `/etc/yum.repos.d/qwcontrol.repo` replacing any existing entries:

```properties
[qwcontrol]
name=qwcontrol
baseurl=https://packages.qwcontrol.com/pagerduty/qwcontrol/rpm_any/rpm_any/$basearch
repo_gpgcheck=1
gpgcheck=0
enabled=1
gpgkey=https://packages.qwcontrol.com/pagerduty/qwcontrol/gpgkey
sslverify=1
sslcacert=/etc/pki/tls/certs/ca-bundle.crt
metadata_expire=300
```

### Install rpm package directly

Download rpm package from the [download page](http://docs.qwcontrol.com/docs/downloads.html) and run:

```bash
sudo rpm -i qwcontrol-{{{qwcontrolVersionFull}}}-1.noarch.rpm
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

1. Navigate to [http://localhost:4440/](http://localhost:4440/user/login) in a browser
1. Log in with the username **admin** and password **admin**

QW Control is now up and running!

Next, learn how to [create your first QW Control Enterprise project](/manual/03-getting-started.md#project-setup)
