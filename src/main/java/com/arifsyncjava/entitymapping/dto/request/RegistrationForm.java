package com.arifsyncjava.entitymapping.dto.request;

public class RegistrationForm {
    private String username;
    private String email;
    private String city;
    private String cityZone;

    public RegistrationForm(String username, String email, String city, String cityZone) {
        this.username = username;
        this.email = email;
        this.city = city;
        this.cityZone = cityZone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityZone() {
        return cityZone;
    }

    public void setCityZone(String cityZone) {
        this.cityZone = cityZone;
    }
}
