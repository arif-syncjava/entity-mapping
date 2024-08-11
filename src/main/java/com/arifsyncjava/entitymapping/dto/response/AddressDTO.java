package com.arifsyncjava.entitymapping.dto.response;

import com.arifsyncjava.entitymapping.jpa.entity.Address;

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
