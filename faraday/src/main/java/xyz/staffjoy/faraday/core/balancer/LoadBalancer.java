package xyz.staffjoy.faraday.core.balancer;

import java.util.List;

/**
 * 负载均衡基类
 */
public interface LoadBalancer {

    String chooseDestination(List<String> destinations);
}
