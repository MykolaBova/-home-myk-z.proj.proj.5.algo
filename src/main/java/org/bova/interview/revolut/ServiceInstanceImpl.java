package org.bova.interview.revolut;

import lombok.Data;

import java.util.Objects;

@Data
public class ServiceInstanceImpl implements ServiceInstance{
    final String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceInstanceImpl that = (ServiceInstanceImpl) o;
        return getAddress().equals(that.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddress());
    }
}
