# Cluster Overview

::: enterprise
:::

## QW Control Enterprise Architecture
![QW Control architecture](~@assets/img/architecture.png)

## Installation
To install a QW Control Enterprise Enterprise instance, download the lastest version from [here](https://download.qwcontrol.com/versions.html), and follow the steps in the [Installation Guide](/administration/install/index.md)

## Requirements
The QW Control Enterprise environment needs the following shared resources:

### Database
- All the cluster members must share the same DB:

  See: [Database Backends](/administration/configuration/database/index.md).

- The keys and project data must be stored in the DB (enabled by default since 2.4.x):

  See: [Storage Facility](/administration/configuration/storage-facility.md)

### Load Balancer
A loadbalancer allows you to achieve high availability in your QW Control Enterprise installation by routing http traffic across several redundant QW Control Enterprise instances.

- Set the `grails.serverURL` parameter of all cluster members (`qwcontrol-config.properties`) with the LB URL.

- Use Sticky session

See: [Loadbalancer](/administration/cluster/loadbalancer/index.md)

### Log Storage
All Cluster members must share the log storage.

See: [Logstore](/administration/cluster/logstore/index.md)

**Note**: If you use the [S3 Log Storage Plugin](/administration/cluster/logstore/s3.md) Be sure to use `com.qwcontrol.qwcontrolpro.amazon-s3` in place of `org.qwcontrol.amazon-s3`. It adds the additional feature:

- _Checkpoint log storage_: This enables viewing the execution logs while the execution is running.

### Authentication
The cluster environment needs a common authentication method. All the instances must have access to the same list of users/groups

See: [Authenticating Users](/administration/security/authentication.md)

### Resource Model
Projects need a common resource model that can be accessed from all cluster members. These are some of the alternatives to achieve this:

- A shared file system
- A script
- A REST endpoint

See: [Node Model Sources](/administration/projects/resource-model-sources/index.md)

## Features:

### Autotakeover
Scheduled jobs are owned by the last cluster member who modified them. Jobs can also be controlled using Cluster Manager. If a cluster member goes down, all scheduled jobs on that cluster member must be moved to another cluster node. This process can be performed automatically using the heartbeat and Autotakeover features in QW Control Enterprise version 2.1.0 and later releases.

See: [Autotakeover](/administration/cluster/autotakeover/index.md)

### Cluster Remote Execution Policy
This feature allows QW Control Enterprise cluster members to forward job executions to other cluster members based on a policy configuration.

See: [Remote Job Execution](/administration/configuration/remote-job-execution.md)

### QW Control Enterprise Replication
This plugin is used for an active/passive configuration. Each cluster member can have its own database.

See [QW Control Enterprise Replication](/administration/cluster/replication/index.md)
