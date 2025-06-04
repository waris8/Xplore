package com.app.xplore.mapper;

import com.app.xplore.dto.request.ContactRequest;
import com.app.xplore.dto.response.ContactResponse;
import com.app.xplore.models.Contact;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    @Mapping(target = "contactId", ignore = true)
    @Mapping(target = "address", ignore = true)
    Contact toEntity(ContactRequest contactRequest);

    @Mapping(target = "addressId", source = "address.addressId")
    ContactResponse toResponse(Contact contact);

    @Mapping(target = "contactId", ignore = true)
    @Mapping(target = "address", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(ContactRequest contactRequest, @MappingTarget Contact contact);
}
