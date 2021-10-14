# Log Filters

A Log Filter processes the output of a workflow step and may transform that output, apply metadata to the output for use by later filters or renderers, or process the output in some way. Some Log Filters can be used to capture output as QW Control variables for use in later steps, or to transform the output for better usability in the QW Control GUI.

A QW Control Job may define multiple Log Filters to process the output of steps within the workflow. A Job may define *global* Log Filters that apply to all steps, as well as *step* log filters that apply only to individual steps. All of the *global* Log Filters for a Job will be processed before individual step filters.

For example, given a job that pulls API results from a web service, the results from the API might be formatted in JSON. The Render Formatted Data log filter can format the output as an HTML table for users running the job.

Conversely, as a different example, for workflow steps that need to feed data to following steps, the Key Value Data filter will parse the assigned step’s output with a regular expression to create key-value data pairs for use in other workflow steps.

Log Filters:

- [Key Value Data](/en/user-guide/log-filters/key-value-data.md)
- [Quiet Output](/en/user-guide/log-filters/quiet-output.md)
- [Highlight Output](/en/user-guide/log-filters/highlight-output.md)
- [Render Formatted Data](/en/user-guide/log-filters/render-formatted-data.md)
- [Mask Passwords](/en/user-guide/log-filters/mask-passwords.md)
- [JSON JQ](/en/user-guide/log-filters/json-jq.md)
- [Multi-line Regex](/en/user-guide/log-filters/multi-line-regex.md)
