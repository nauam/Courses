# Upgrading to QW Control 3.2


::: tip
See other [Upgrading](/upgrading/) Documents if you are upgrading from 3.0 or earlier.
:::

## Upgrading from QW Control 3.0 Using Debian/RPM packaging


The value of `framework.projects.dir` in the default install of QW Control 3.2 in the config file `framework.properties` has changed to:

	framework.projects.dir=/var/lib/qwcontrol/projects

QW Control 3.0.x has this :

	framework.projects.dir=/var/qwcontrol/projects


If before the upgrade the `/var/qwcontrol/projects` is NOT empty, 3.2 will start properly, but if `/var/qwcontrol/projects` is empty, it will be deleted and 3.2 won't start until you modify the proper line in `framework.properties` to be `/var/lib/qwcontrol/projects`.

An error with this message may occur in the QW Control console at startup:

```
... nested exception is java.lang.IllegalArgumentException: project base directory could not be created. /var/qwcontrol/projects

```

## Webhooks
:::tip
Webhooks were feature flagged in `3.1.x` and disabled by default.  Your instance may not have used Webhooks prior to the 3.2 release.  If you did not use Webhooks prior to version 3.2 you can skip this issue.
:::

### Advanced Run Job (Enterprise)
The [condition](/manual/webhooks/advanced-run-job.html#conditions) type `matches` has been renamed to `equals`. Webhooks using `Advanced Run Job` with `matches` conditions will need to be updated to work properly. These configurations can be updated by:  

- Loading the webhook in the UI, selecting `equals` on the appropriate conditions, and then saving

   **OR**

- Updating the webhooks configuration through the [API](/api/qwcontrol-api.html#webhooks-incubating)