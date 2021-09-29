# HashiCorp Consul (Enterprise)

QW Control Enterprise users have the option to use HashiCorp Consul as a method to edit QW Control's configuration properties. By doing so, it allows users to manage the configuration for all of their services in one place. In terms of QW Control, this feature is very beneficial because it allows users to edit configurations across all of their QW Control instances. So, instead of having to change a configuration for each instance, change it once in Hashicorp and it will apply to all instances.  

## Getting Started 

To begin, make sure that both QW Control and HashiCorp Consul are installed. The easiest way to get HashiCorp up and running is using their docker image. The docker image is named "consul." Consul can be found at localhost:8500, but this can also be changed from within Consul. For more information about installing, visit [Consul](https://www.consul.io/docs/install).
Next, make sure that QW Control knows to use Consul for configuration. There are a couple of different ways to do that:

### RPM, Debian and Docker Users

For RPM, Debian and Docker users, the best way to specify that QW Control should use Consul, is by defining the environment variable to be true. To do so, add the following to the `/etc/qwcontrol/profile` file:
```
QWCONTROL_CONSUL_ENABLED=true
```

### War Users

For customers who use installed QW Control using the .war, there are a couple different options.
1. Define the environment variable just like RPM, Debian and Docker users by adding the following to the `/etc/qwcontrol/profile` file:
2. Pass the property as a flag when starting QW Control. An example of that would look like the following:
```
java -Xmx4g -Dqwcontrol.consul.enabled=true -jar qwcontrol-{{{qwcontrolVersionFull}}}.war
```

### Setting the Consul server in QW Control

Now that QW Control knows to use Consul, we can shut down QW Control and look at the newly created `bootstrap.yml` file, which is located in the ${rdbase}/server/config directory. In there, it will specify the host of Consul. The host property should be set to the ip address or hostname of your Consul server.

## Services in Consul

In HashiCorp, QW Control may not appear right away as a service. However, once the QW Control service is fully up and running, it will show up in HashiCorp.

## Adding the QW Control Configuration in Consul

To create a new Key/Value pair, click on the key/value tab in the top of Consul. Next, create a folder called "config", with another folder called "qwcontrol" inside of it. Inside of the QW Control folder is where all the QW Control configuration will be placed. Begin by creating a key/value pair named "data." Now, copy and paste all the contents in the `qwcontrol-config.properties` file into the value for that key. After that, comment out the entire `qwcontrol-config.properties` file. Now, when relaunching QW Control, it will pull the configuration settings from Consul. 

:::warning
If a key/value pair is defined that conflicts with a setting configured in a file on the server (qwcontrol-config.properties), then the file on the server will always override the Consul configuration. 
:::

## Example: Using HashiCorp for a Cluster

![Consul - Dispatching to Specific Instance](~@assets/img/qwcontrol-server-id.png)

If using a cluster of QW Control Enterprise instances, then you can specify the server id when creating the folder for the config key/values. Looking at the example above, there are two different folders created inside of the config directory. One called QW Control and one called QW Control with a long id after it. That is how to specify a server to have all the configuration settings applied to. By just naming the folder QW Control, we apply the configuration to all members of the cluster. So, in order to apply the configuration to just one instance, we need to create a directory called "qwcontrol,{server_id}"(as shown in image above). To find the the server id, click on the gears icon in the top right hand corner of QW Control and select "System Report." On the next page, you will see the following box containing your server UUID: 
![Server ID](~@assets/img/server-id-location.png)

:::warning
If a server ID is specified, those configuration settings will always override the settings specified for all instances in the "qwcontrol" folder. 
:::

### Levels of Precedence for Clusters
1. A file on the server (qwcontrol-config.properties)
2. In Consul, specifying the server to be applied to.
3. In Consul, not specifying a server.
