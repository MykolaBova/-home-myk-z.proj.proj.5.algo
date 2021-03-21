package org.bova.interview.revolut;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoadBalancerImplTest {

    @Test
    void positiveFlow() {
        Loadbalancer loadbalancer = new LoadBalancerImpl();
        ServiceInstance serviceInstance = new ServiceInstanceImpl("address1");
        loadbalancer.registerService(serviceInstance);
        assertTrue(loadbalancer.isRegistered(serviceInstance));
    }

    @Test
    void negativeFlow_isRegistered() {
        Loadbalancer loadbalancer = new LoadBalancerImpl();
        ServiceInstance serviceInstance = new ServiceInstanceImpl("address1");
        assertFalse(loadbalancer.isRegistered(serviceInstance));
    }

    @Test
    void negativeFlow_tooMuchInstances() {
        Loadbalancer loadbalancer = new LoadBalancerImpl();

        loadbalancer.registerService(new ServiceInstanceImpl("address1"));
        loadbalancer.registerService(new ServiceInstanceImpl("address2"));
        loadbalancer.registerService(new ServiceInstanceImpl("address3"));
        loadbalancer.registerService(new ServiceInstanceImpl("address4"));
        loadbalancer.registerService(new ServiceInstanceImpl("address5"));
        loadbalancer.registerService(new ServiceInstanceImpl("address6"));
        loadbalancer.registerService(new ServiceInstanceImpl("address7"));
        loadbalancer.registerService(new ServiceInstanceImpl("address8"));
        loadbalancer.registerService(new ServiceInstanceImpl("address9"));

        assertTrue(loadbalancer.registerService(new ServiceInstanceImpl("address10")));
        assertFalse(loadbalancer.registerService(new ServiceInstanceImpl("address11")));
    }

    @Test
    void negativeFlow_sameAddress() {
        Loadbalancer loadbalancer = new LoadBalancerImpl();

        loadbalancer.registerService(new ServiceInstanceImpl("address1"));
        assertFalse(loadbalancer.registerService(new ServiceInstanceImpl("address1")));
    }

}