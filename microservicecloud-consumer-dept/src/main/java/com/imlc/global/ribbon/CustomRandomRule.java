package com.imlc.global.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @Auther: L.C
 * @Date: 2019-07-04 12:02
 */
public class CustomRandomRule extends AbstractLoadBalancerRule {

    // 总共调用次数
    private int total = 0;
    // 当前服务的机器号
    private int currentIndex = 0;

    /**
     * total = 0, 当total==5，指针移动
     * index = 0, 当前对外提供服务的服务器地址
     * total = 0， index = 1
     *
     * @Author: L.C
     * @Date: 2019-07-04 12:34
     */
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

            if (total < 5) {
                server = upList.get(currentIndex);
                total++;
            } else {
                total = 0;
                currentIndex++;
                if (currentIndex >= upList.size()) {
                    currentIndex = 0;
                }
            }

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

}