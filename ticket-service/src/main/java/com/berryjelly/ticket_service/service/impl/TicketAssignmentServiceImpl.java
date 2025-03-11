package com.berryjelly.ticket_service.service.impl;

import com.berryjelly.ticket_service.mapper.TicketEntityMapper;
import com.berryjelly.ticket_service.model.apimodel.TicketAssignmentRequest;
import com.berryjelly.ticket_service.model.businessobject.TicketBo;
import com.berryjelly.ticket_service.model.entity.TicketEntity;
import com.berryjelly.ticket_service.repository.TicketRepository;
import com.berryjelly.ticket_service.service.TicketAssignmentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketAssignmentServiceImpl implements TicketAssignmentService {

    private final TicketRepository ticketRepository;
    private final TicketEntityMapper ticketEntityMapper;

    public TicketAssignmentServiceImpl(TicketRepository ticketRepository, TicketEntityMapper ticketEntityMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketEntityMapper = ticketEntityMapper;
    }

    @Override
    public TicketBo assignTicketToUsers(TicketAssignmentRequest request) {
        Optional<TicketEntity> ticketEntityOptional = ticketRepository.findByResourceId(request.ticketResourceId());
        if (ticketEntityOptional.isPresent()){
            TicketEntity entity = ticketEntityOptional.get();
            entity.setAssignedUserIds(request.assignedUserIds());
            TicketEntity result = ticketRepository.save(entity);
            return ticketEntityMapper.mapEntityToBo(result);
        }

        return null;
    }
}
