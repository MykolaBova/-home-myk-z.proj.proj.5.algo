package org.bova.interview.revolut;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/*
Alex Pimenov
3:05 PM
Register instances to the Load Balancer –
    the max number of accepted backend-instances from the load balancer is 10.
    Each instance should have a unique address.

    - throw eccpetion if instance number > 10

    - store information about service address
        Sting address

    Alex Pimenov
    3:45 PM
    Develop an algorithm that, when invoking the Load Balancer's get() method
        multiple times, should return one backend-instance choosing between the registered ones randomly.
 */
public class LoadBalancerImpl implements Loadbalancer {
    List<ServiceInstance> serviceInstances;
    Random random;

    LoadBalancerImpl() {
        serviceInstances = new ArrayList<>();
        random = new Random();
    }

    @Override
    public boolean registerService(ServiceInstance serviceInstance) {

        if(serviceInstances.contains(serviceInstance)) {
            return false;
        }
        if(serviceInstances.size() == 10) {
            return false;
        }
        serviceInstances.add(serviceInstance);
        return true;
    }

    public boolean isRegistered(ServiceInstance serviceInstance) {
        return serviceInstances.contains(serviceInstance);
    }

    public ServiceInstance get() {
        return serviceInstances.get(random.nextInt(serviceInstances.size()));
    }
}
