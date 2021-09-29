# Using HAProxy as a loadbalancer

<!---
Original:
http://support.qwcontrol.com/customer/en/portal/articles/2894842-health-check-based-on-execution-mode-for-haproxy-lb
http://support.qwcontrol.com/customer/en/portal/articles/2894840-enable-cgi-script-on-jetty
--->

To avoid sending traffic to unavailable nodes, HAProxy can check the health of
their downstream services via http or tcp. This document explains how to create
a custom health check for QW Control.


### On HAProxy, add the following settings

The web load balancer serving traffic to the QW Control instance should be configured with the health check.

- Add the "httpchk" with the URI of the [execution status API endpoint](/api/qwcontrol-api.md#get-current-execution-mode). The token value that you want to use is needed.
- Add the "http-check" with the expected status (in this case 200)

```
backend default_service
cookie JSESSIONID prefix nocache
option httpchk get /api/32/system/executions/status?authtoken=<TOKEN_VALUE>
http-check expect status 200
server qwcontrol1 192.168.0.1:4440 cookie qwcontrol1 check inter 2000 rise 2 fall 3
server qwcontrol2 192.168.0.2:4440 cookie qwcontrol2 check inter 2000 rise 2 fall 3
server qwcontrol3 192.168.0.3:4440 cookie qwcontrol3 check inter 2000 rise 2 fall 3
```

### Check if HAProxy redirect to the active instance

Once the web load balancer has been configured with the health check, any instance that is not in "active" mode will not be passed traffic.

![HAProxy status](~@assets/img/haproxy-status.png)
