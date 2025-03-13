package com.berryjelly.user_service.service;

import com.berryjelly.user_service.repository.UserRepository;
import model.messaging.kafkamodels.TicketAssignedV1;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserValidationService {

    private final UserRepository userRepository;
    private final KafkaTemplate<String, TicketAssignedV1> kafkaTemplate;

    public UserValidationService(UserRepository userRepository,
                                 KafkaTemplate<String, TicketAssignedV1> kafkaTemplate) {
        this.userRepository = userRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "user-validation-requests", groupId = "user-service-group")
    public void validateUsers(TicketAssignedV1 event){

        List<Long> validUsers = event.getUserIds().stream()
                .filter(userRepository::existsById)
                .collect(Collectors.toList());

        event.setValidUserIds(validUsers);
        kafkaTemplate.send("user-validation-responses", event);
    }
}
