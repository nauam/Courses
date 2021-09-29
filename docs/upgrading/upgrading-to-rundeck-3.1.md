# Upgrading to QW Control 3.1

## RPM package

> **Note:** There is now only a single RPM package required (qwcontrol-config is no more)

**Updating**  
For convenience the `3.1.0` rpm package obsoletes `qwcontrol-config`. When qwcontrol is updated
it will remove this package and take over the files without prompting. 

**Downgrading**  
If you need to downgrade and/or install a specific version of QW Control prior to `3.1.0`:
```
yum --setopt=obsoletes=0 downgrade qwcontrol-3.0.24.20190719-1.201907192053
```

Otherwise there should be no problem upgrading from QW Control 3.0 to QW Control 3.1

If you are upgrading from an older version, please review the Upgrade Guide for the specific version.

## Docker using OpenShift

Some changes to the Docker image were added to support OpenShift, see [#4826](https://github.com/qwcontrol/qwcontrol/pull/4826).

- The `qwcontrol` user's default group needs to be `root(0)`
- Any files and directories QW Control uses need to have the appropriate `root` group and permissions set
- Use `chown=qwcontrol:root` in Dockerfile with `ADD` and `COPY`
- Use `chmod 0775` on directories and files as appropriate


## Upgrading from QW Control 3.0 Using Debian/RPM packaging


The value of `framework.projects.dir` in the default install of QW Control 3.2 in the config file `framework.properties` has changed to:

	framework.projects.dir=/var/lib/qwcontrol/projects

QW Control 3.0.x has this :

	framework.projects.dir=/var/qwcontrol/projects


If before the upgrade the `/var/qwcontrol/projects` is NOT empty, 3.2 will start properly, but if `/var/qwcontrol/projects` is empty, it will be deleted and 3.2 won't start until you modify the proper line in `framework.properties` to be `/var/lib/qwcontrol/projects`.

An error with this message may occur in the QW Control console at startup:

```
... nested exception is java.lang.IllegalArgumentException: project base directory could not be created. /var/qwcontrol/projects

```
