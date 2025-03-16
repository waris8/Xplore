package com.app.xplore.models;

import lombok.Data;

@Data
public class Address {
    private String addressId;
    private String address;
    private String city;
    private String state;
    private String pin;
    private String country;

}
