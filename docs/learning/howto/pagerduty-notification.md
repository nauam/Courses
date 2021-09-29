# QW Control PagerDuty Notification Plugin

QW Control integrates with PagerDuty’s incident management platform, which provides notifications, automatic escalations, on-call scheduling, and other functionality to help teams detect and fix problems quickly.

In this guide we will show you how to trigger an event in PagerDuty after executing a job in QW Control. This functionality is available in both QW Control Community and Enterprise.   

:::tip
Note, there are many more [PagerDuty plugins](https://docs.qwcontrol.com/docs/manual/webhooks/pagerduty-run-job.html.) available for QW Control Enterprise users
:::

QW Control Notifications are actions triggered based on the result of a Job that was executed.  There are five conditions that can trigger QW Control notifications, those conditions are:

- `onstart` - Triggers an action when the Job **started**
- `onsuccess` - Triggers an action when the Job **completed without any errors**
- `onfailure` - Triggers an action when the Job **failed or was aborted**
- `onavgduration` - Triggers an action when the execution **exceeds the average duration of the Job.**
- `onretryablefailure` - Triggers an action when the Job **failed after a retry.**

The [QW Control PagerDuty Notification Plugin](https://github.com/qwcontrol-plugins/pagerduty-notification) lets you send trigger events to your PagerDuty service. This plugin is available for the Community version and bundled with the Enterprise version of QW Control.


## Installing the plugin
:::: tabs
::: tab Community Install

1. Go to Gear Icon (upper right) > Plugins > Find plugins.
    <br><br>![Find Plugins](@assets/img/howto-pdnotif-findplugin.png)<br><br>
1. On the Plugin Repository search, type "pagerduty" and enter.
1. On the PagerDuty Notification block press the "Install" button.
    <br><br>![alt_text](@assets/img/howto-pdnotif-installplugin.png)<br><br>
4. After a few seconds the plugins are installed on your QW Control Instance.

:::
::: tab Enterprise Install

The PagerDuty Notification plugin is bundled with Enterprise builds.  No need to install separately.

:::
::::

## Configuring PagerDuty
>(Same Steps for Community and Enterprise)

A fundamental requirement is the PagerDuty integration key, which connects the QW Control integration with a PagerDuty Service. To locate and copy it follow these steps:

1. Log in to PagerDuty.
1. Go to the Services menu click the button to create a New Service.
1. Give the Service a name and assign it to an escalation policy. Add an integration by selecting the Events API V2, as seen below:
    <br><br>![Create Service](@assets/img/howto-pdnotif-createservice.png)<br><br>
1. When the Service is created you’ll be shown the Integrations tab. Inside that tab copy the value for the Integration Key and save it for later on in your setup.
    <br><br>![Integration Key](@assets/img/howto-pdnotif-integrationkey.png)<br><br>

## Configuring the QW Control PagerDuty Notification

These steps will configure the Notification plugin globally (across all QW Control projects). There are options to configure the plugin per project covered in the [main documentation](https://github.com/qwcontrol-plugins/pagerduty-notification#configuration).

:::: tabs
::: tab Community Steps

1. Stop the QW Control service: `systemctl stop qwcontrold`.
1. With any text editor open the `framework.properties` file (located at `/etc/qwcontrol` path).
1. Add the following line to the `framework.properties` file (replace “your-service-key” with the PagerDuty service key you copied earlier):
```
framework.plugin.Notification.PagerDutyNotification.service_key=your-service-key
```
1. Save the file.
1. Start the QW Control service: `systemctl start qwcontrold.`
:::
::: tab Enterprise Steps

QW Control Enterprise includes a Configuration Management module to set configuration settings via the GUI and store them in the QW Control database. Database storage shares configuration options with all your cluster members and centralizes configuration.

1. Click on the **System Menu > System Configuration**.
    <br><br>![System Configuration](@assets/img/howto-pdnotif-systemconf.png)<br><br>
2. Now, click on the **Add Config** button (top right)
    <br><br>![Add Config Entry](@assets/img/howto-pdnotif-addconf.png)<br><br>
3. In the _Property Name_ box add: `framework.plugin.Notification.PagerDutyNotification.service_key`. In the _Property Value_ box add the PagerDuty integration key you copied earlier, set `Global` on the _Strata Menu_ and press the **Add** button.
    <br><br>![Add Notification Entry](@assets/img/howto-pdnotif-addpdentry.png)<br><br>
4. Press the **Save** button in the top right to save the Config changes.
    <br><br>![Save Configuration](@assets/img/howto-pdnotif-saveconf.png)<br><br>

Now, QW Control Enterprise is configured to use PagerDuty notifications, no restart is required.
:::
::::

## Sending Notifications to a PagerDuty Service.

1. Create or edit a job.
1. Go to the **Workflow** tab and add a step. For this example, use a Command step with an `echo "hello world!"` command.
1. Go to the **Notifications** tab.
1. On the “On Success” event, click the "+ Add Notification" Button.
   <br><br>![Add Notification](@assets/img/howto-pdnotif-addnotification.png)<br><br>
1. In the Notification Type list select "PagerDuty".
   <br><br>![Select PagerDuty](@assets/img/howto-pdnotif-addpdnotif.png)<br><br>
1. The Incident subject is editable, by default the plugins include [job context variables](/manual/job-workflows.html#context-variables). Click on the **Save** button for the Notification and **Save** button for the job.
1. Run the job.

When you check the PagerDuty service incidents, you should see a new triggered incident is created.

<br><br>![Incident Created in PD](@assets/img/howto-pdnotif-incidentcreated.png)<br><br>
