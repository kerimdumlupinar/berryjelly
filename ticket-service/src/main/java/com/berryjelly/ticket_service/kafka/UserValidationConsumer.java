package com.berryjelly.ticket_service.kafka;

import com.berryjelly.ticket_service.model.entity.TicketEntity;
import com.berryjelly.ticket_service.repository.TicketRepository;
import model.messaging.kafkamodels.UserValidationResponse;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserValidationConsumer {

    private final TicketRepository ticketRepository;

    public UserValidationConsumer(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @KafkaListener(topics = "user-validation-responses", groupId = "ticket-service-group")
    public void receiveValidationResponse(UserValidationResponse response){

        List<Long> invalidUserIds = new ArrayList<>(response.getUserIds());
        invalidUserIds.removeAll(response.getValidUserIds());

        if (!invalidUserIds.isEmpty()){
            throw new RuntimeException("There are invalid ids in the request");
        }

        TicketEntity ticketEntity = ticketRepository.findByResourceId(response.getRequestId()).get();
        ticketEntity.setAssignedUserIds(response.getValidUserIds());
        ticketRepository.save(ticketEntity);

    }

}
