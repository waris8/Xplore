package com.app.xplore.dto.request;

import java.util.List;

public record ContactRequest(
    String email,
    List<Long> contactNo,
    String addressId
) {}
