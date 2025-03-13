package com.berryjelly.ticket_service.service.impl;

import com.berryjelly.ticket_service.kafka.UserValidationConsumer;
import com.berryjelly.ticket_service.kafka.UserValidationProducer;
import com.berryjelly.ticket_service.mapper.TicketEntityMapper;
import com.berryjelly.ticket_service.model.apimodel.TicketAssignmentRequest;
import com.berryjelly.ticket_service.model.entity.TicketEntity;
import com.berryjelly.ticket_service.repository.TicketRepository;
import com.berryjelly.ticket_service.service.TicketAssignmentService;
import model.messaging.kafkamodels.UserValidationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TicketAssignmentServiceImpl implements TicketAssignmentService {

    private final TicketRepository ticketRepository;
    private final TicketEntityMapper ticketEntityMapper;
    private final UserValidationProducer userValidationProducer;
    private final UserValidationConsumer userValidationConsumer;
    public TicketAssignmentServiceImpl(TicketRepository ticketRepository, TicketEntityMapper ticketEntityMapper,
                                       UserValidationProducer userValidationProducer, UserValidationConsumer userValidationConsumer) {
        this.ticketRepository = ticketRepository;
        this.ticketEntityMapper = ticketEntityMapper;
        this.userValidationProducer = userValidationProducer;
        this.userValidationConsumer = userValidationConsumer;
    }

    @Override
    public void assignTicketToUsers(TicketAssignmentRequest request) {
        Optional<TicketEntity> ticketEntityOptional = ticketRepository.findByResourceId(request.ticketResourceId());
        if (ticketEntityOptional.isEmpty()){
            throw new RuntimeException("Ticket with resource id: " + request.ticketResourceId() + " not found");
        }

        publishUserValidationRequest(ticketEntityOptional.get().getResourceId(), request.assignedUserIds());

    }

    public void publishUserValidationRequest(String ticketResourceId, List<Long> assignedUserIds){

        UserValidationRequest request = new UserValidationRequest();
        request.setRequestId(ticketResourceId);
        request.setUserIds(assignedUserIds);
        userValidationProducer.sendUserValidationRequest(request);
    }
}
