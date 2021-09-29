# Using Postgres as a database backend

This is a simple guide for setting up PostgreSQL for use with QW Control.

## Install PostgreSQL

You can "yum install" or "apt-get install" the server, or you can download rpms manually if you like. See [PostgreSQL installation](https://wiki.postgresql.org/wiki/Detailed_installation_guides)

## Setup QW Control Database

We have to create the database and user for QW Control.

If it is not running, start Postgres (with `service postgresql-<version> start` or similar).

Switch to 'postgres' user and use the 'psql' commandline tool to access the db:

    $ su postgres
    $ psql

Once you have the 'postgres=#'' prompt, enter the following commands to create the qwcontrol database:

    postgres=# create database qwcontrol;

Now, create a user and grant privileges to connect to this DB.

    postgres=# create user qwcontroluser with password 'qwcontrolpassword';
    postgres=# grant ALL privileges on database qwcontrol to qwcontroluser;

You can then exit the psql prompt.

You may also have to add a pg_hba.conf entry for this user. See [pg_hba.conf documentation](https://www.postgresql.org/docs/9.5/static/auth-pg-hba-conf.html)

## Configure QW Control

Now you need to configure QW Control to connect to this DB as described in: [Administrator Guide - QW Control Configuration - Database - Customize the Datasource](/administration/configuration/database/index.md#customize-the-datasource).

Update your `qwcontrol-config.properties` and configure the datasource:

```properties
dataSource.driverClassName = org.postgresql.Driver
dataSource.url = jdbc:postgresql://pgsql.qwcontrol.local/qwcontrol
dataSource.username = qwcontroluser
dataSource.password = qwcontrolpassword
```

With recent QW Control versions, PostgreSQL connector is bundled.

Now, you can start QW Control.
