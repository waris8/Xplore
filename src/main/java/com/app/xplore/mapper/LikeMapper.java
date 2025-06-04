package com.app.xplore.mapper;

import com.app.xplore.dto.request.LikeRequest;
import com.app.xplore.dto.response.LikeResponse;
import com.app.xplore.models.Like;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LikeMapper {
    LikeMapper INSTANCE = Mappers.getMapper(LikeMapper.class);

    @Mapping(target = "likeId", ignore = true)
    @Mapping(target = "user", ignore = true)
    Like toEntity(LikeRequest likeRequest);

    @Mapping(target = "userId", source = "user.userId")
    LikeResponse toResponse(Like like);

    @Mapping(target = "likeId", ignore = true)
    @Mapping(target = "user", ignore = true)
    @org.mapstruct.BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(LikeRequest likeRequest, @MappingTarget Like like);
}
