package com.berryjelly.user_service.service.impl;

import com.berryjelly.user_service.model.apimodel.UserRequest;
import com.berryjelly.user_service.model.businessobject.UserBo;
import com.berryjelly.user_service.service.UserCreationService;
import com.berryjelly.user_service.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserCreationService userCreationService;

    public UserServiceImpl(UserCreationService userCreationService) {
        this.userCreationService = userCreationService;
    }

    @Override
    public UserBo getUser(String resourceId) {
        return null;
    }

    @Override
    public UserBo saveUser(UserBo userBo) {
        return userCreationService.saveUser(userBo);
    }
}
