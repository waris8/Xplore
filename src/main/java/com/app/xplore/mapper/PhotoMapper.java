package com.app.xplore.mapper;

import com.app.xplore.dto.request.PhotoRequest;
import com.app.xplore.dto.response.PhotoResponse;
import com.app.xplore.models.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PhotoMapper {
    PhotoMapper INSTANCE = Mappers.getMapper(PhotoMapper.class);

    @Mapping(target = "photoId", ignore = true)
    @Mapping(target = "uploadedAt", ignore = true)
    @Mapping(target = "user", ignore = true)
    Photo toEntity(PhotoRequest photoRequest);

    @Mapping(target = "userId", source = "user.userId")
    PhotoResponse toResponse(Photo photo);

    @Mapping(target = "photoId", ignore = true)
    @Mapping(target = "uploadedAt", ignore = true)
    @Mapping(target = "user", ignore = true)
    @org.mapstruct.BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromRequest(PhotoRequest photoRequest, @MappingTarget Photo photo);
}
