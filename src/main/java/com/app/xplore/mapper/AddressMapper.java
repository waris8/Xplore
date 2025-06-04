package com.app.xplore.mapper;

import com.app.xplore.dto.request.AddressRequest;
import com.app.xplore.dto.response.AddressResponse;
import com.app.xplore.models.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Mapping(target = "addressId", ignore = true)
    Address toEntity(AddressRequest addressRequest);

    AddressResponse toResponse(Address address);

    @Mapping(target = "addressId", ignore = true)
    void updateEntityFromRequest(AddressRequest addressRequest, @MappingTarget Address address);
}
