package com.berryjelly.user_service.service;

import com.berryjelly.user_service.repository.UserRepository;
import model.messaging.kafkamodels.UserValidationRequest;
import model.messaging.kafkamodels.UserValidationResponse;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserValidationService {

    private final UserRepository userRepository;
    private final KafkaTemplate<String, UserValidationResponse> kafkaTemplate;

    public UserValidationService(UserRepository userRepository,
                                 KafkaTemplate<String, UserValidationResponse> kafkaTemplate) {
        this.userRepository = userRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "user-validation-requests", groupId = "user-service-group")
    public void validateUsers(UserValidationRequest request){

        List<Long> validUsers = request.getUserIds().stream()
                .filter(userRepository::existsById)
                .collect(Collectors.toList());

        UserValidationResponse response = new UserValidationResponse();
        response.setRequestId(request.getRequestId());
        response.setUserIds(request.getUserIds());
        response.setValidUserIds(validUsers);
        kafkaTemplate.send("user-validation-responses", response);
    }
}
