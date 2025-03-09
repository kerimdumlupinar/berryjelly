package com.berryjelly.user_service.mapper;

import com.berryjelly.user_service.model.apimodel.UserRequest;
import com.berryjelly.user_service.model.businessobject.UserBo;
import org.mapstruct.Mapper;

@Mapper(implementationName = "UserApiModelMapperImpl")
public abstract class UserApiModelMapper {

    public abstract UserBo mapApiModelToBo(UserRequest request);

    public abstract UserRequest mapBoToApiModel(UserBo userBo);
}
