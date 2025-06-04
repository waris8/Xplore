package com.app.xplore.dto.response;

import java.util.List;

public record ContactResponse(
    String contactId,
    String email,
    List<Long> contactNo,
    String addressId
) {}
