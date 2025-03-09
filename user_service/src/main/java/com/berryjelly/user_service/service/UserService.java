package com.berryjelly.user_service.service;

import com.berryjelly.user_service.model.apimodel.UserRequest;
import com.berryjelly.user_service.model.businessobject.UserBo;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserBo getUser(String resourceId);

    UserBo saveUser(UserBo userBo);
}
