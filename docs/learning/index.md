# Learning QW Control

With QW Control, it is simple and easy to create automation workflows from existing tools or scripts. The Learning section includes a _[Getting Started Tutorial](/learning/tutorial/preparing.md)_ and _[How to Guides](/learning/howto/overview.md)_ that help new users quickly become productive with the QW Control server and tools. Instructions are provided for both Enterprise and Community versions of QW Control.

Visit the _[Tutorials](/learning/tutorial/preparing)_ to see practical step-by-step guides that help you get your QW Control account up and running - starting with installing and configuring QW Control.  The Tutorial section is built around our Welcome Projects that provide product simulations for both QW Control versions.  

Use the [How To Guides](/learning/howto/overview.md) to accomplish tasks using QW Control Enterprise version and where applicable, the Community version. The How To guides go deeper into specific topics and are commonly built around the Welcome Project.

## Getting Started

### Essential Concepts

Several fundamental concepts underlie and drive the QW Control system. If you are a new user, knowing about them will help you more effectively use and integrate QW Control into your environment.
The first step is to learn some key QW Control Terms in our [Terminology Tutorial](terminology.md).

### Using QW Control

If a running QW Control instance isn't already available to you,
there are a couple ways you can try it.

#### Welcome Projects

Both QW Control product versions, Enterprise and Community, have a companion set of code at the following links. These code bases allow running QW Control in a Docker environment with the Welcome Project preloaded.

- Enterprise: [https://github.com/qwcontrolpro/welcome-project](https://github.com/qwcontrolpro/welcome-project)
- Community: [https://github.com/qwcontrol/welcome-project-community](https://github.com/qwcontrol/welcome-project-community)

Use the [Welcome Projects Starter How To guide](/learning/howto/welcome-project-starter.md) to learn how to get started with these environments.

:::tip
Note: The Enterprise version will require a license file. If you aren’t currently an Enterprise customer and you’re interested in using that please [contact us here](https://www.qwcontrol.com/see-demo).
:::

:::warning
It is possible to run the Welcome Projects in other environments, but some exercise steps will need to be adjusted for your specific environment
:::

#### Download and Install
Get the latest release at our [download](https://download.qwcontrol.com/) site and
  install the QW Control software. There are several package formats.
  Choose the one that best suits the target infrastructure.

  After installation, be sure QW Control has been started.
  ::: tip
  See [Startup](/administration/maintenance/startup.md) to learn how to  startup and shutdown qwcontrol.
  :::

The default port for the web interface is `4440`. If you
installed QW Control on your local machine, go to this URL: `http://localhost:4440`

### Login

QW Control requires every user to login. The default installation
defines an "admin" user with access to perform all actions.
Use "admin" for username and password.

![Login form](~@assets/img/fig0202.png)
