package com.berryjelly.user_service.service.impl;

import com.berryjelly.user_service.mapper.UserEntityMapper;
import com.berryjelly.user_service.model.businessobject.UserBo;
import com.berryjelly.user_service.repository.UserRepository;
import com.berryjelly.user_service.service.UserCreationService;
import model.businessobject.AuditMetaDataBo;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Locale;

@Service
public class UserCreationServiceImpl implements UserCreationService {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserCreationServiceImpl(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public UserBo saveUser(UserBo userBo) {
        String resourceId = RandomStringUtils.randomAlphanumeric(10).toUpperCase(Locale.ROOT);
        userBo.setResourceId(resourceId);
        userBo.setMeta(createAuditMetaDataBo());
        userRepository.save(userEntityMapper.mapBoToEntity(userBo));
        return userBo;
    }

    private AuditMetaDataBo createAuditMetaDataBo(){

        LocalDateTime now = LocalDateTime.now();
        AuditMetaDataBo meta = new AuditMetaDataBo();
        meta.setCreatedAt(now);

        return meta;
    }
}
