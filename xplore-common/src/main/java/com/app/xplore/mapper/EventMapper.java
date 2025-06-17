package com.app.xplore.mapper;

import com.app.xplore.dto.request.EventRequest;
import com.app.xplore.dto.response.EventResponse;
import com.app.xplore.models.Address;
import com.app.xplore.models.events.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    @Mapping(target = "eventId", ignore = true)
    @Mapping(target = "eventVenue", source = "eventVenueId", qualifiedByName = "mapVenueIdToAddress")
    @Mapping(target = "eventCreatedDate", ignore = true)
    @Mapping(target = "eventUpdatedDate", ignore = true)
    @Mapping(target = "availableSeats", source = "capacity")
    Event toEntity(EventRequest eventRequest);

    @Mapping(target = "eventVenueId", source = "eventVenue.addressId")
    EventResponse toResponse(Event event);

    @Mapping(target = "eventId", ignore = true)
    @Mapping(target = "eventVenue", source = "eventVenueId", qualifiedByName = "mapVenueIdToAddress")
    @Mapping(target = "eventCreatedDate", ignore = true)
    @Mapping(target = "eventUpdatedDate", ignore = true)
    @Mapping(target = "availableSeats", ignore = true)
    @org.mapstruct.BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(EventRequest eventRequest, @MappingTarget Event event);

    @Named("mapVenueIdToAddress")
    default Address mapVenueIdToAddress(String eventVenueId) {
        if (eventVenueId == null) {
            return null;
        }
        Address address = new Address();
        address.setAddressId(eventVenueId);
        return address;
    }
}
