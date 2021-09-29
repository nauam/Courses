# Default Users

## Logins

QW Control supports a number of user directory configurations. By
default, the installation uses a file based directory, but connectivity to
LDAP is also available.
See [Authentication](/administration/security/authentication.md).

The QW Control installation process will have defined a set of temporary
logins useful during the getting started phase.

- `user`: Has access to run commands and jobs but unable to modify job
  definitions. Password: "user"
- `admin`: Belongs to the "admin" group and is automatically granted
  the "admin" and "user" role privileges. Password: "admin"

## Group membership

If you installed QW Control using the RPM installation method, it will
have created a unix group called "qwcontrol".

```
$ groups qwcontrol
qwcontrol : qwcontrol
```

Consult the [usermod] command to modify a user account.

[usermod]: https://linux.die.net/man/8/usermod
