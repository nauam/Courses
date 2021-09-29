# Replication

In order to keep a QW Control Enterprise Cluster in sync, we provide plugins to replicate QW Control state across instances.

## Job Replication Plugin

The Job replication plugin is a SCM Export plugin included with QW Control Enterprise. It automatically replicates Job definitions to a secondary QW Control instance whenever a Job is modified within a project.

Enable the plugin in the SCM section of the Configuration page for a project.

### Configuration

Endpoint URL

: Remote QW Control API URL

API Token

: API Token for authentication to the remote QW Control

Project

: Name of remote Project to use, or `${job.project}` to maintain the same name

## Execution Replication File Storage Plugin

The Execution Replication File Storage Plugin included with QW Control Enterprise creates a QW Control formatted Project Archive for each execution, and uploads it to a remote
QW Control server, to replicate the execution data

Enable the plugin in qwcontrol-config.properties:

```properties
qwcontrol.execution.logs.fileStoragePlugin=ExecutionReplicationPlugin
```

Configuration will be defined in framework.properties/project.properties:

```properties
framework.plugin.ExecutionFileStorage.ExecutionReplicationPlugin.qwcontrolUrl=http://host
framework.plugin.ExecutionFileStorage.ExecutionReplicationPlugin.apiToken=...
framework.plugin.ExecutionFileStorage.ExecutionReplicationPlugin.project=${execution.project}
framework.plugin.ExecutionFileStorage.ExecutionReplicationPlugin.timeout=30
```
