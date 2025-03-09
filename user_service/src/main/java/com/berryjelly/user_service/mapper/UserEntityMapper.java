package com.berryjelly.user_service.mapper;

import com.berryjelly.user_service.model.businessobject.UserBo;
import com.berryjelly.user_service.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "UserEntityMapperImpl")
public abstract class UserEntityMapper {

    public abstract UserBo mapEntityToBo(UserEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", source = "meta.createdAt")
    public abstract UserEntity mapBoToEntity(UserBo userBo);
}
