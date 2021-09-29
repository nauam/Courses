# Storage Facility

This document describes the QW Control Storage Facility which is used both for Key Storage, and for Project Definition Storage.

## Storage Facility

The Storage facility provides a filesystem-like structure for storing files. Each file is located with a "/"-separated "path" and a name, similar to a file system path.

Currently the Storage Facility is split into two separate containers:

- [Key Storage](#key-storage)
- [Project Storage](#project-storage)

Both containers use the same storage mechanisms, but they can be configured independently of each other,
and have different APIs for modification.

## Key Storage

The Key Storage container allows storing public keys, private keys, and passwords securely. The
contents of these files can be accessed by Node Execution plugins for authenticating to remote nodes.
The contents can be written via the QW Control API, but only public keys can be read via the API.

See the chapter: [Key Storage](/administration/security/key-storage.md).

When configuring Key Storage providers, the configuration entries in `qwcontrol-config.properties` start with:

    qwcontrol.storage.provider.[index]

And converter plugins start with:

    qwcontrol.storage.converter.[index]

## Project Storage

Similar to Key Storage, the Project Storage container keeps files related to QW Control Projects:

- contents of `etc/project.properties` - the Project configuration
- contents of `readme.md` and `motd.md` - Readme and MOTD files

Access to these contents can be made via the QW Control API.

See the chapter: [Project Setup](/administration/projects/configuration.md)

When configuring Project Storage providers, the configuration entries in `qwcontrol-config.properties` start with:

    qwcontrol.config.storage.provider.[index]

And converter plugins start with:

    qwcontrol.config.storage.converter.[index]

## Storage backends

The location of stored data can be either on the filesystem, the database, or some external system via usage of a **Storage Plugin**.

QW Control provides these built-in implementations:

- `filesystem` - stores files locally on the filesystem
- `db` - stores file data as BLOBs in the database

It is highly recommended that you configure QW Control to use a relational database instead of the default file-based data storage.

For information on configuring QW Control to use specific Databases, see:

- [Administor Guide > QW Control Configuration > Database](/administration/configuration/database/index.md)

To develop your own storage plugin, see:

- [Storage Plugin Development](/developer/07-storage-plugin.md).

## Storage Converters

Files can be encrypted in the storage backend by use of a [Storage Converter plugin](/developer/08-storage-converter-plugins.md). A typical plugin would encrypt data at write time, and decrypt it at read time.

The Storage Converter Plugin handles reading and writing the content for any matching resources. The subsequent data is stored in the storage backend (on-disk or in a database) alongside the metadata for the file.

Converter plugins do not have to manage storing the data, that will be handled by the Storage backend.

To develop your own storage converter plugin, see:

- [Storage Converter Plugin Development](/developer/08-storage-converter-plugins.md).

### Using Encryption

QW Control provides a bundled Storage Converter plugin implementation:

- `jasypt-encryption` - encrypts the storage contents: [Configuring Plugins - Bundled Plugins - Jasypt Encryption Plugin](/administration/configuration/plugins/bundled-plugins.md#jasypt-encryption-plugin)
