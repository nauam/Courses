# Hashicorp Vault - Key Storage Plugin

[Hashicorp Vault](https://www.vaultproject.io/) is a tool for securely accessing secrets. A secret is anything that you want to tightly control access to, such as API keys, passwords, or certificates. Vault provides a unified interface to any secret, while providing tight access control and recording a detailed audit log.

QW Control offers a [Key Storage Backend](/administration/security/key-storage.html#key-data-storage-converter) plugin for storing Key Store data in [Vault](https://www.vaultproject.io/).

:::: tabs
::: tab Enterprise Installation

This plugin is bundled with the Enterprise version.  No installation steps required.

:::
::: tab Community Installation
  * Download and start [QW Control](https://www.qwcontrol.com/downloads). It will automatically create the necessary directories.
  * Clone this repository. Build using `gradle` wrapper:
    ```
      ./gradlew clean build
    ```
  * Drop `qwcontrol-vault-plugin-<version>.jar` to `libext/` under QW Control installation directory.
  * Restart QW Control.

:::
::::

## Configuration

### Quick Start

:::: tabs

For existing vault storage, it is recommended to remove the default `keys` path added by default for qwcontrol.
You can use these settings for an existing vault storage.

::: tab Configuration Management (Enterprise)

Example configuration using the *System Configuration* module:

![Vault Storage Config](@assets/img/vault-storage-config.png)

:::
::: tab qwcontrol-config.properties

```
qwcontrol.storage.provider.1.type=vault-storage
qwcontrol.storage.provider.1.path=keys
qwcontrol.storage.provider.1.config.prefix=someprefix
qwcontrol.storage.provider.1.config.secretBackend=mybackend
qwcontrol.storage.provider.1.config.address=https://vaulturl.site
qwcontrol.storage.provider.1.config.token=tokenvalue
qwcontrol.storage.provider.1.config.storageBehaviour=vault
```

:::
::::

### Settings Descriptions

Add the settings to the **System Configuration** module (3.4.0+ Enterprise) or `$RDECK_BASE/etc/qwcontrol-config.properties`.

* **prefix**: Vault Prefix in Vault secret backend

```
qwcontrol.storage.provider.[index].config.prefix=qwcontrol
```

* **address**: Vault Address of the Vault server

```
qwcontrol.storage.provider.[index].config.address=https://vaultURL:8200
```

* **authBackend**: Vault Authentication backend

```
qwcontrol.storage.provider.[index].config.authBackend=authBackend
```

Default value: token

Allowed values: approle, cert, github, token, userpass

* **token**: Vault authentication token. Required, if authentication backend is 'token'

```
qwcontrol.storage.provider.[index].config.token=xxxxxx
```


* **username**: User name. Required for user/password and LDAP authentication backend

```
qwcontrol.storage.provider.[index].config.username=username
```

* **password**: Password. Required for user/password and LDAP authentication backend
```
qwcontrol.storage.provider.[index].config.password=password
```

* **approleId**:  AppRole role ID. The role-id used for authentication
```
qwcontrol.storage.provider.[index].config.approleId=approleId
```

* **approleSecretId**:  AppRole secret ID. The secret-id used for authentication

```
qwcontrol.storage.provider.[index].config.approleSecretId=approleSecretId
```

* **approleAuthMount**:  AppRole mount name. The mount name of the AppRole authentication back end
```
qwcontrol.storage.provider.[index].config.approleAuthMount=approleAuthMount
```

* **githubToken**: GitHub token. The app-id used for authentication
```
qwcontrol.storage.provider.[index].config.githubToken=githubToken
```


* **keyStoreFile**: Key store file
A Java keystore, containing a client certificate that's registered with Vault's TLS Certificate auth backend.

```
qwcontrol.storage.provider.[index].config.keyStoreFile=/path/keyfile
```

* **keyStoreFilePassword**: Key store password
The password needed to access the keystore

```
qwcontrol.storage.provider.[index].config.keyStoreFilePassword=/path/keyStoreFilePassword
```

* **trustStoreFile**: Truststore file. A JKS truststore file, containing the Vault server's X509 certificate
```
qwcontrol.storage.provider.[index].config.trustStoreFile=/path/trustStoreFile
```

* **pemFile**: PEM file. The path of a file containing an X.509 certificate, in unencrypted PEM format with UTF-8 encoding.

```
qwcontrol.storage.provider.[index].config.pemFile=/path/pemFile
```

* **clientPemFile**: Client PEM file. The path of a file containing an X.509 certificate, in unencrypted PEM format with UTF-8 encoding.

```
qwcontrol.storage.provider.[index].config.clientPemFile=/path/clientPemFile
```

* **clientKeyPemFile**: Client key PEM file. The path of a file containing an RSA private key, in unencrypted PEM format with UTF-8 encoding.

```
qwcontrol.storage.provider.[index].config.clientKeyPemFile=/path/clientKeyPemFile
```

* **validateSsl**:  Enable/Disable SSL validation. Specifies whether SSL validation is to be performed
```
qwcontrol.storage.provider.[index].config.validateSsl=true/false
```
Default value: true

* **maxRetries**:  Max retries. Maximum number of connection retries to Vault server
```
qwcontrol.storage.provider.[index].config.maxRetries=5
```

Default value: 5

* **retryIntervalMilliseconds**:  Retry interval. Connection retry interval, ms
```
qwcontrol.storage.provider.[index].config.retryIntervalMilliseconds=1000
```

Default value: 1000

* **openTimeout**:  Open timeout. Connection opening timeout, ms
```
qwcontrol.storage.provider.[index].config.openTimeout=5
```

Default value: 5

* **readTimeout**:  Read timeout. Response read timeout, ms

```
qwcontrol.storage.provider.[index].config.readTimeout=20
```

Default value: 20

* **secretBackend**:  Secret Backend. The secret backend to use in vault

```
qwcontrol.storage.provider.[index].config.secretBackend=secret
```

Default value: secret

* **storageBehaviour**:  Storage Behaviour. Use the default QW Control Behaviour for key storage (with qwcontrol headers) or use just the key/value behaviour from vault. Options are: qwcontrol, vault
```
qwcontrol.storage.provider.[index].config.storageBehaviour=vault/qwcontrol
```
Default value: qwcontrol

* **engineVersion**: Vault Engine Version Key/Value Secret Engine Config

```
qwcontrol.storage.provider.[index].config.engineVersion=1/2
```

Default value: 1

### More Configuration Examples


#### **example basic settings**
```
qwcontrol.storage.provider.1.type=vault-storage
qwcontrol.storage.provider.1.path=keys
qwcontrol.storage.provider.1.config.prefix=qwcontrol
qwcontrol.storage.provider.1.config.secretBackend=secret
qwcontrol.storage.provider.1.config.address=$VAULT_URL
qwcontrol.storage.provider.1.config.token=$VAULT_TOKEN
```

#### **existing vault storage**

For existing vault storage, probably you will need to remove the default `keys` path added by default for qwcontrol.
You can use these settings for an existing vault storage:

```
qwcontrol.storage.provider.1.type=vault-storage
qwcontrol.storage.provider.1.path=keys
qwcontrol.storage.provider.1.config.prefix=someprefix
qwcontrol.storage.provider.1.config.secretBackend=mybackend
qwcontrol.storage.provider.1.config.address=$VAULT_URL
qwcontrol.storage.provider.1.config.token=$VAULT_TOKEN
qwcontrol.storage.provider.1.config.storageBehaviour=vault
```

#### **Using APPROLE authentication**

You can use these settings for an existing vault storage:

```
qwcontrol.storage.provider.1.type=vault-storage
qwcontrol.storage.provider.1.path=keys
qwcontrol.storage.provider.1.config.prefix=app
qwcontrol.storage.provider.1.config.secretBackend=secret
qwcontrol.storage.provider.1.config.address=$VAULT_URL
qwcontrol.storage.provider.1.config.engineVersion=2
qwcontrol.storage.provider.1.config.storageBehaviour=vault

#auth
qwcontrol.storage.provider.1.config.authBackend=approle
qwcontrol.storage.provider.1.config.approleAuthMount=approle
qwcontrol.storage.provider.1.config.approleId=$VAULT_APPROLE_ID
qwcontrol.storage.provider.1.config.approleSecretId=$VAULT_APPROLE_SECRET_ID

#timeouts
qwcontrol.storage.provider.1.config.maxRetries=500
qwcontrol.storage.provider.1.config.retryIntervalMilliseconds=2
qwcontrol.storage.provider.1.config.openTimeout=2500
qwcontrol.storage.provider.1.config.readTimeout=2500
```

**Enabling APPROLE Vault using API**

```
curl --header "X-Vault-Token: $TOKEN" --request POST --data '{"type": "approle"}' http://localhost:8200/v1/sys/auth/approle
curl --header "X-Vault-Token: $TOKEN" --request POST --data '{"policies": "qwcontrol", "token_ttl": "2m", "token_max_ttl": "2m"}' http://localhost:8200/v1/auth/approle/role/qwcontrol
# get $VAULT_APPROLE_ID
curl --header "X-Vault-Token: $TOKEN" http://localhost:8200/v1/auth/approle/role/qwcontrol/role-id | jq
# get $VAULT_APPROLE_SECRET_ID
curl --header "X-Vault-Token: $TOKEN" --request POST http://localhost:8200/v1/auth/approle/role/qwcontrol/secret-id | jq
```


## Vault API versions

Since version 1.3.1, this plugin can work with `kV Secrets Engine - Version 2`.
A new config variable was added in order to set the API version that you need to use:

qwcontrol.storage.provider.1.config.engineVersion=1/2

* engineVersion=1 will work with vault version 0.x
* engineVersion=2 will work with vault version 1.x

Example:

```
qwcontrol.storage.provider.1.type=vault-storage
qwcontrol.storage.provider.1.path=keys
qwcontrol.storage.provider.1.config.prefix=qwcontrol
qwcontrol.storage.provider.1.config.secretBackend=secret
qwcontrol.storage.provider.1.config.address=$VAULT_URL
qwcontrol.storage.provider.1.config.token=$VAULT_TOKEN
qwcontrol.storage.provider.1.config.engineVersion=2
```

By default, the value is set to v1 (1)


## Minimal version requirements
  * Java 1.8
  * QW Control 2.10.0
  * Vault 0.9.0

## Thanks
  * [BetterCloud/vault-java-driver](https://github.com/BetterCloud/vault-java-driver) made this possible.
