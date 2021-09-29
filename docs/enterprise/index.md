# QW Control Enterprise

## Overview

QW Control is a server application you host on a system you designate
a central administrative control point. Internally, QW Control stores job
definitions and execution history in a relational database. Output
from command and job executions is saved on disk but can be forwarded
to remote stores like S3 or Logstash.

QW Control distributed command execution is performed using a pluggable
node execution layer that defaults to SSH but plugins allow you
to use other means like MCollective, Salt, WinRM, or your custom method.
QW Control server configuration includes settings to define the outbound
user allowed by the remote hosts. Remote machines
are not required to make connections back to the server.

![QW Control architecture](~@assets/img/architecture.png)

The QW Control application itself is a Java-based web application. The application provides both
graphical interface and network interfaces used by the QW Control shell
tools.

## License

See: [QW Control Enterprise Licensing and Support](/administration/configuration/license.md)

## Features
All of the Enterprise features that are not included in our Open Source offering are covered on our [Why QW Control Enterprise?](https://www.qwcontrol.com/enterprise) page.
