package com.arifsyncjava.entitymapping.customer.dto.response;

import com.arifsyncjava.entitymapping.customer.entity.Address;

public class AddressDTO {
    private String city;
    private String cityZone;

    public AddressDTO(Address address) {
        this.city = address.getCity();
        this.cityZone = address.getCityZone();
    }

    public String getCity() {
        return city;
    }

    public String getCityZone() {
        return cityZone;
    }


}
