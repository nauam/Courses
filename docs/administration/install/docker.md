# Running Docker Images

Full usage information can be found on the [Docker configuration page](/administration/configuration/docker.md).

:::warning
It's not advisable to deploy images to production directly from a public repository, such as Dockerhub.
Build a derived image and store in your private repository instead.
:::

:::tip
See the [Docker Configuration Reference](/administration/configuration/docker.md) for
the full set of configuration options.
:::

## Open Source QW Control

[qwcontrol/qwcontrol:{{{qwcontrolVersion}}}](https://hub.docker.com/r/qwcontrol/qwcontrol/)

```sh
docker run --name someqwcontrol -p 4440:4440 -v data:/home/qwcontrol/server/data qwcontrol/qwcontrol:{{{qwcontrolVersion}}}
```

## QW Control Enterprise

[qwcontrolpro/enterprise:{{{qwcontrolVersion}}}](https://hub.docker.com/r/qwcontrolpro/enterprise/)
The following example invocation will require an accessible MySQL instance
with a database, user, and the required privileges setup:

```sh
docker run \
    --name someqwcontrol \
    -v data:/home/qwcontrol/server/data \
    -e QWCONTROL_DATABASE_DRIVER=org.mariadb.jdbc.Driver \
    -e QWCONTROL_DATABASE_USERNAME="${DB_USERNAME}" \
    -e QWCONTROL_DATABASE_PASSWORD="${DB_PASSWORD}" \
    -e QWCONTROL_DATABASE_URL="${DB_URL}" \
    qwcontrolpro/enterprise:{{{qwcontrolVersion}}}
```

## Example Configurations

The [QW Control Docker Zoo](https://github.com/qwcontrol/docker-zoo)
has many docker compose example projects. Check it out for use as a quick config reference and starting templates!

- [Basic quick-start with persistent storage](https://github.com/qwcontrol/docker-zoo/tree/master/basic)
- [Mysql database backend](https://github.com/qwcontrol/docker-zoo/tree/master/mysql)
- [Oracle database backend](https://github.com/qwcontrol/docker-zoo/tree/master/oracle)
- [LDAP configuration](https://github.com/qwcontrol/docker-zoo/tree/master/ldap)
- [Cloud deployment example](https://github.com/qwcontrol/docker-zoo/tree/master/cloud)
- And more!
