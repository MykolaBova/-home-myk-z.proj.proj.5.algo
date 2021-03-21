package org.bova.interview.revolut;

public interface Loadbalancer {
    boolean registerService(ServiceInstance serviceInstance);

    boolean isRegistered(ServiceInstance serviceInstance);

    ServiceInstance get();
}
