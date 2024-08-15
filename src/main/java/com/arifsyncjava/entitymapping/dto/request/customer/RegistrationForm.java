package com.arifsyncjava.entitymapping.dto.request.customer;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegistrationForm {
    private String username;
    private String email;
    private String city;
    private String cityZone;

    public RegistrationForm() {
    }

    public RegistrationForm(String username, String email, String city, String cityZone) {
        this.username = username;
        this.email = email;
        this.city = city;
        this.cityZone = cityZone;
    }


}
