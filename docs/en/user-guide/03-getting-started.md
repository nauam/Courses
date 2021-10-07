# Getting Started

The best way to get started with QW Control is through our [Learning section](/en/learning/).  
[Terminology](/en/learning/tutorial/terminology), [Tutorials](/en/learning/tutorial/preparing) and
[How To articles](/en/learning/how-to/overview) that show the many ways to use QW Control.

## Essential Concepts

Several fundamental concepts underlie and drive the QW Control system.
If you are a new user, knowing about them will
help you use or integrate QW Control into your environment.

- **Projects**: A _[project](/en/administration/projects/index.md)_ is a place to separate management activity.
  All QW Control activities occur within the context of a project.
  Multiple projects can be maintained on the same QW Control server.
- **Jobs** : A _job_ encapsulates a sequence of steps, job options and nodes where the steps execute. See [Jobs](/en/user-guide/04-jobs.md) and [Creating Jobs](/en/user-guide/creating-jobs.md).
- **Nodes**: A _[node](/en/user-guide/05-nodes.md)_ is a resource that is either a physical or virtual instance
  of a network accessible host.
  A _resource model_ is a representation of Nodes in a project.
- **Commands**: A _[command](/en/user-guide/06-commands.md)_ is a single executable string executed on a Node.
  QW Control invokes commands on nodes via a _node executor_,
  which evaluates the command string and executes it.
- **Executions**: An _[execution](/en/user-guide/07-executions.md)_ is a representation of the activity of a running or completed
  command or job. The data about the execution is used in QW Control to monitor
  the progress of a job or command, and later for reporting about what happened.
- **Role-based Access Control Policies**: A QW Control _[access control policy](/en/administration/security/authorization.md)_ grants users
    and user groups certain privileges to perform actions against QW Control resources
    like projects, jobs, nodes, commands and API.
- **Plugins**: Extending QW Control functionality is done through _plugins_. Plugins exist
  to execute commands on nodes, perform steps in a job,
  send a notification about job status, gather
  information about the hosts in your network, copy a file to a remote
  server, store and stream logs, talk to a user directory, and so much more.

  Our Enterprise version includes built-in plugins to further enhance functionality for [Scheduling](/en/schedules/project-schedules.md) job executions, providing [Guided Tours](/en/tour-manager.md), incorporating [Health Checks](/en/healthchecks.md), and much more.

  See [Job Plugins](/en/user-guide/job-plugins.md) and [Plugin Developer Guide](/en/developer/index.md) and [QW Control Plugins](/en/dplugins/index.md).

## Download and Installation

If a running QW Control instance isn't already available to you,
there are a couple ways you can try it.

- Check out the Docker based Welcome Projects described on the [Learning Overview Page](/en/learning/).
- Visit our download site [download](/en/http://qwsoftware.com.br/downloads.html) and
  install the QW Control software. There are several package formats.
  Choose the one that best suits the target infrastructure.
  After installation, be sure QW Control has been started.
  ::: tip
  See [Startup](/en/administration/maintenance/startup.md) to learn how to  startup and shutdown QW Control.
  :::

The default port for the web interface is `4440`. If you
installed QW Control on your local machine, go to this URL: `http://locahost:4440`

## Login

QW Control requires every user to login. The default installation
defines an "admin" user with access to perform all actions.
Use "admin" for username and password.

![Login form](/assets/img/fig0202.png)

## Project setup

A new installation will not contain any projects so QW Control will present
you with a dialog to create one. Press the "New Project" button to create
a project.
Fill the project creation form with a desired name. Project names can
contain letters and numbers, but do not use spaces or special characters.
The [project](/en/administration/projects/index.md)
section
will teach you how to add Nodes, automate the creation and maintenance of
QW Control projects.

Once the project has been created, you are ready to use your QW Control instance.

## QW Control Graphical Console (GUI)

### Navigation

Using the project picker in the top bar it is possible to quickly search, list and switch between the various projects configured.
Once inside a project navigation is done using the navigation bar on the left side of the page.
 _Dashboard_, _Jobs_, _Nodes_, _Commands_, _Activity_, and other pages.
Project administrators will also be able to access the _Project Settings_ pages menu.

For those with QW Control administrator access, the System settings can be accessed by clicking the gear icon in the page header.

Finally, the user profile and logout functions are found under the User icon.

![Top level navigation](/assets/img/fig0201.png)

#### Projects menu

Select the desired project. If only one project exists, the menu will
automatically be selected. You can create new projects from
this menu, too.

#### Dashboard

View the project description, Readme and executions summary.
QW Control Enterprise users may see additional visualizations for schedules and execution history.

#### Jobs

From the Jobs page, one can list, create, and run Jobs. A
configurable filter allows a user to limit the Job listing to
Jobs matching the filtering criteria. These filter settings can be
saved to a user profile. Only authorized jobs will be visible.

::: tip
See [Jobs](/en/user-guide/04-jobs.md).
:::

#### Nodes

The Nodes page is used to browse the Nodes configured in your
Project resource model. A filter control can be used to
limit the listing to just the Node resources
matching the filter criteria. Given the appropriate authorization,
you can also execute ad hoc commands to your filtered node set.

::: tip
See [Nodes](/en/user-guide/05-nodes.md).
:::

#### Commands

The Commands page lets you execute arbitrary commands against the
nodes that match the node filter.

::: tip
See [Commands](/en/user-guide/06-commands.md).
:::

#### Activity

From the Activity page, one can view currently executing Commands
and Jobs, or browse execution history. The execution
history can be filtered based on user-selected parameters. Once the
filter has been set, the matching history is displayed. The current
filter settings also configure an RSS link, found in the top right of
the page (see QW Control Administration to enable RSS).

::: tip
See [Activity](/en/user-guide/08-activity.md).
:::

#### System

If your login belongs to the "admin" group and therefore is granted
"admin" privileges, a "System" icon will be displayed in
the top navigation bar.
From the System menu you can access the Key Storage,
System Configuration, Access Control, System Report, Log Storage,
List Plugins, Password Utility and Execution model.

::: tip
See [Configure](/en/user-guide/system.configs.md)
:::

#### User

The User menu lets you logout and view your profile page.
Your user profile lists your group memberships and a form to list
and generate API tokens.

::: tip
See [User](/en/user-guide/10-user.md)
:::

## Command Line Tools

QW Control includes a number of shell tools to dispatch commands, load
and run Job definitions, and interact with the dispatcher's queue. These
command line tools are an alternative to functions accessible in the
graphical console.

See the [Command line tools](/en/user-guide/command-line-tools/index.md).

## API

You can also use the Web API to interface with all aspects of Node
and Job execution.

See the [QW Control API](/en/api/qwcontrol-api.md) page for a reference on the
endpoints and examples.

## Document Formats

If you prefer to manage job and resource definitions using text files,
you can do so using XML or YAML formats.

See the [Document Format Reference](/en/user-guide/document-format-reference/index.md).
