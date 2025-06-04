package com.app.xplore.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {
    private String addressId;
    private String address;
    private String city;
    private String state;
    private String pin;
    private String country;
}
