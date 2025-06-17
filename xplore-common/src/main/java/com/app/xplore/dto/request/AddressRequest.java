package com.app.xplore.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {
    private String address;
    private String city;
    private String state;
    private String pin;
    private String country;
}
