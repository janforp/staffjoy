package xyz.staffjoy.faraday.core.balancer;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机算法的负载均衡
 */
public class RandomLoadBalancer implements LoadBalancer {

    @Override
    public String chooseDestination(List<String> destinations) {
        int hostIndex = destinations.size() == 1 ? 0 : ThreadLocalRandom.current().nextInt(0, destinations.size());
        return destinations.get(hostIndex);
    }
}
