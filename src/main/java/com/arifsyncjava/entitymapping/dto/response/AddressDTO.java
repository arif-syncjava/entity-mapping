package com.arifsyncjava.entitymapping.dto.response;

import com.arifsyncjava.entitymapping.jpa.entity.Address;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddressDTO {
    private String city;
    private String cityZone;

    public AddressDTO() {
    }

    public AddressDTO(Address address) {
        this.city = address.getCity();
        this.cityZone = address.getCityZone();
    }


}
