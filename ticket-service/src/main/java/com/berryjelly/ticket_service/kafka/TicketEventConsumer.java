package com.berryjelly.ticket_service.kafka;

import com.berryjelly.ticket_service.model.entity.TicketEntity;
import com.berryjelly.ticket_service.repository.TicketRepository;
import model.messaging.kafkamodels.TicketAssignedV1;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketEventConsumer {

    private final TicketRepository ticketRepository;

    public TicketEventConsumer(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @KafkaListener(topics = "user-validation-responses", groupId = "ticket-service-group")
    public void consumeTicketAssignedEvent(TicketAssignedV1 event){
        List<Long> invalidUserIds = new ArrayList<>(event.getUserIds());
        invalidUserIds.removeAll(event.getValidUserIds());

        if (!invalidUserIds.isEmpty()){
            throw new RuntimeException("There are invalid ids in the request");
        }

        TicketEntity ticketEntity = ticketRepository.findByResourceId(event.getTicketResourceId()).orElseThrow();

        ticketEntity.setAssignedUserIds(event.getValidUserIds());
        ticketRepository.save(ticketEntity);
    }
}
