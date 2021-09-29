# Storage Plugin

## About

Storage plugins provide the backend for storing file contents uploaded to the [Key Storage](/administration/security/key-storage.md) via the [Key Storage API](/api/qwcontrol-api.md#key-storage).

The Storage facility stores **Resources** in a **Path-oriented** tree structure. Each **Resource** has a set of key-value _metadata_, and a stream of binary data (the _content_).

QW Control provides two built-in providers, `db` and `file`, which store the contents in the database or on the filesystem.

When installed, Storage Plugins can be configured to apply to all storage, or for everything below a certain Path.

## Configuring

See: [Configuring the Storage Plugins](/administration/security/key-storage.md#configuring-the-storage-plugins).

## Java Plugin Type

- _Note_: Refer to [Java Development](/developer/01-plugin-development.md#java-plugin-development) for information about developing a Java plugin for QW Control.

**Plugin Interface**

- [StoragePlugin]({{{javaDocBase}}}/com/dtolabs/qwcontrol/plugins/storage/StoragePlugin.html)

This simply extends [Tree]({{{javaDocBase}}}/org/qwcontrol/storage/api/Tree.html) to store resource of type [ResourceMeta]({{{javaDocBase}}}/com/dtolabs/qwcontrol/core/storage/ResourceMeta.html).

Refer to the [QW Control Storage API javadocs]({{{javaDocStorageApiBase}}}) for more information about the underlying storage API.

**Service Name**

- [`Storage`]({{{javaDocBase}}}/com/dtolabs/qwcontrol/plugins/ServiceNameConstants.html#Storage)

**Additional Compile-time Dependency**

Your build tool will need to include `org.qwcontrol:qwcontrol-storage-api:{{{qwcontrolVersionFull}}}` as a dependency.

See: [org.qwcontrol:qwcontrol-storage-api:\{{{qwcontrolVersionFull}}}](https://search.maven.org/artifact/org.qwcontrol/qwcontrol-storage-api/{{{qwcontrolVersionFull}}}/jar)
