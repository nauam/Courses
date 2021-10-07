# QW Control Automation - ServiceNow Application

::: enterprise
:::

Our ServiceNow&reg; application can be found on the ServiceNow&reg; Store.  The application is free to Enterprise customers.  To request the application please contact your Account Executive or Customer Success contact.

## Requirements

The application is supported on Orlando and Paris ServiceNow&reg; releases.  We will be working towards Quebec certification soon.

An active QW Control Enterprise license for version 3.2.x or higher is also required.

## Requesting the application

1. [Visit the QW Control Application ServiceNow Store page](/en/https://store.servicenow.com/sn_appstore_store.do#!/store/application/6e8e2effdb8f041034a5d487f49619e2/1.0.6).
1. Login and click the **Request App** button.
1. A message will be sent to our team for approval.  Once approved a Customer Success or Support tech will contact with more details.

## Configuration Steps

After the app has been installed in your ServiceNow&reg; instance there will be a new "QW Control Automation" Module Group.

> Note: The ServiceNow login account will need the `admin` role and `x_runde_qwcontrol_it.qwcontrol_app_user` roles to configure these settings.

1. Create an [API Key](/en/user-guide/10-user.md#user-api-tokens) in QW Control.
1. Click **Configure QW Control Connection** and fill out the fields on the form with your environment details.
    - **Protocol**: Choose if your QW Control instance is running over `http` or `https`.
    - **Destination**: Enter the IP address or domain name where your QW Control is running.
    - **Port Number**: Confirm the port number QW Control is running on
    - **API Key**: Paste in the API Key from Step 1
    - **API Version**: In rare occurrences the API version can be adjusted.  Default and minimum version is `34`.

![Configuration Settings](/en/@assets/img/sn-properties-config.png)


## Using the Application

### How it works
The ServiceNow application leverages QW Control's Webhooks feature to trigger jobs in your QW Control environment.  To create automation within ServiceNow please check out our Learning Article for [How to setup Webhooks to trigger your QW Control Jobs](/en/learning/howto/using-webhooks.md).

### Importing Webhooks

The Scheduled Scripts module will list the Populate Webhooks Scheduled Script.  This script can be used to import all available webhooks.  By default it comes unscheduled.  In order to keep your webhook listing current the script can be scheduled to run on a regular interval.

### Calling Webhooks from ServiceNow&reg; Code

Upon import webhooks from your QW Control Projects will be added to the **QW Control Webhooks** table.  A 'Code Example' field provides basic code that can be used in ServiceNow&reg; Client or Server side scripts to call that specific webhook.

![Webhook Record](/en/@assets/img/sn-webhook-record.png)

```javascript
var rd = new QW Control();
rd.callWebhook('11','{}');
```
The `callWebhook` function is part of a Server Include entry. The function takes two arguments to call a particular webhook.
 - ID value (e.g. "11")
 - An optional custom payload in JSON format "{}".  (Note: if no payload is needed leave the two empty braces as shown in example code).

### Examples

Below is an example Incident table based UI Action script that includes the ticket number and hostname value from the associated CMDB CI.

```javascript
try {
    var rd = new QW Control();
    //Call QW Control Webhook Server Include with ([webhook id], [payload])
    rd.callWebhook('11', '{"ticket":"' + current.number + '", "host":"' + current.cmdb_ci.host_name + '"}');
    action.setRedirectURL(current);
} catch (e) {
    gs.error(e);
}
```
## Additional Details

### Helpful Info

- Currently the application is only designed to connect to a single QW Control instance.
- The rights of the User API Key that is created will determine the access to Projects/Webhooks/Jobs that the application will have.  It is recommended to use a service account for this and manage the appropriate rights through that account.

### ServiceNow&reg; Roles included

- executor: Assign this role to allow users to execute QW Control actions.  The role provides read-only access to the minimum necessary application components.
- qwcontrol_app_user:  Grants access to the QW Control Automation module listing and allow read/write access to most application areas.
