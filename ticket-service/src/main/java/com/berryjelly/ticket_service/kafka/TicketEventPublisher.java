package com.berryjelly.ticket_service.kafka;

import com.berryjelly.ticket_service.model.apimodel.TicketAssignmentRequest;
import model.messaging.kafkamodels.TicketAssignedV1;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TicketEventPublisher {

    private final KafkaTemplate<String, TicketAssignedV1> kafkaTemplate;

    public TicketEventPublisher(KafkaTemplate<String, TicketAssignedV1> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishTicketAssignedEvent(TicketAssignmentRequest request){
        TicketAssignedV1 event = new TicketAssignedV1();
        event.setTicketResourceId(request.ticketResourceId());
        event.setUserIds(request.assignedUserIds());
        kafkaTemplate.send("user-validation-requests", event);
    }
}
