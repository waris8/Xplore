package com.app.xplore.mapper;

import com.app.xplore.dto.request.RoomRequest;
import com.app.xplore.dto.response.RoomResponse;
import com.app.xplore.models.rooms.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

    @Mapping(target = "roomId", ignore = true)
    @Mapping(target = "roomCreatedDate", ignore = true)
    Room toEntity(RoomRequest roomRequest);

    RoomResponse toResponse(Room room);

    @Mapping(target = "roomId", ignore = true)
    @Mapping(target = "roomCreatedDate", ignore = true)
    @org.mapstruct.BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(RoomRequest roomRequest, @MappingTarget Room room);
}
