---
title: Migrate From Bintray
lang: en-US
---

# Migrating From Bintray
**April 27th, 2021**

In February, JFrog announced that it would be ending their Bintray distribution service. The official download distributions of QW Control are now available on a new hosting service. See below for full details about new repository sources and guidance about signing keys. **Any automation that your team has created utilizing QW Control’s Bintray repositories will need to be updated prior to May 1st, 2021**.

## Migration Instructions
:::warning
QW Control has rotated the signing key used to sign release packages. All previously released
`deb`, `rpm`, and `war` packages have been re-signed and uploaded. The new public key can be found [here in the QW Control packaging repo](https://github.com/qwcontrol/packaging/blob/main/pubring.gpg).
:::


:::::::: tabs

::::::: tab Enterprise

:::: tabs
::: tab Deb
### Quick setup script
The [quick setup script](https://github.com/qwcontrol/packaging/blob/main/scripts/deb-setup.sh) will configure the QW Control Enterprise repository,
import the new repository signing key, and update apt. Legacy configuration
will be replaced.

```bash
curl https://raw.githubusercontent.com/qwcontrol/packaging/main/scripts/deb-setup.sh 2> /dev/null | sudo bash -s qwcontrolpro
```

### Manual setup

Import the repo signing key:
```bash
curl -L https://packages.qwcontrol.com/pagerduty/qwcontrolpro/gpgkey | sudo apt-key add -
```

Add the following to `/etc/apt/sources.list.d/qwcontrol.list` replacing existing entries:
```
deb https://packages.qwcontrol.com/pagerduty/qwcontrolpro/any/ any main
deb-src https://packages.qwcontrol.com/pagerduty/qwcontrolpro/any/ any main
```

Update apt cache:
```bash
sudo apt-get update
```

:::

::: tab Rpm
### Quick setup script
The [quick setup script](https://github.com/qwcontrol/packaging/blob/main/scripts/rpm-setup.sh) will configure the QW Control Enterprise repository. Legacy configuration
will be replaced.

```bash
curl https://raw.githubusercontent.com/qwcontrol/packaging/main/scripts/rpm-setup.sh 2> /dev/null | sudo bash -s qwcontrolpro
```

### Manual setup

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

:::

::: tab War
Visit the [QW Control download page](https://download.qwcontrol.com) for updated direct
download links.
:::
::::

:::::::


::::::: tab Community
:::: tabs
::: tab Deb
### Quick setup script
The [quick setup script](https://github.com/qwcontrol/packaging/blob/main/scripts/deb-setup.sh) will configure the QW Control Community repository,
import the new repository signing key, and update apt. Legacy configuration
will be replaced.

```bash
curl https://raw.githubusercontent.com/qwcontrol/packaging/main/scripts/deb-setup.sh 2> /dev/null | sudo bash -s qwcontrol
```

### Manual setup

Import the repo signing key:
```bash
curl -L https://packages.qwcontrol.com/pagerduty/qwcontrol/gpgkey | sudo apt-key add -
```

Add the following to `/etc/apt/sources.list.d/qwcontrol.list` replacing existing entries:
```bash
deb https://packages.qwcontrol.com/pagerduty/qwcontrol/any/ any main
deb-src https://packages.qwcontrol.com/pagerduty/qwcontrol/any/ any main
```

Update apt cache:
```bash
sudo apt-get update
```

:::

::: tab Rpm
### Quick setup script
The [quick setup script](https://github.com/qwcontrol/packaging/blob/main/scripts/rpm-setup.sh) will configure the QW Control Enterprise repository. Legacy configuration
will be replaced.

```bash
curl https://raw.githubusercontent.com/qwcontrol/packaging/main/scripts/rpm-setup.sh 2> /dev/null | sudo bash -s qwcontrol
```

### Manual setup

Remove `bintrayqwcontrolpro-rpm.repo` if it exists.

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

:::

::: tab War
Visit the [QW Control download page](https://docs.qwcontrol.com/downloads.html) for updated direct
download links.
:::
:::::::

::::::::
