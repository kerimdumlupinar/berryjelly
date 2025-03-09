package com.berryjelly.user_service.service;

import com.berryjelly.user_service.model.businessobject.UserBo;
import org.springframework.stereotype.Service;

@Service
public interface UserCreationService {

    UserBo saveUser(UserBo userBo);
}
