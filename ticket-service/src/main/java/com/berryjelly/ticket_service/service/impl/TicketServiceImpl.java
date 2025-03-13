package com.berryjelly.ticket_service.service.impl;

import com.berryjelly.ticket_service.kafka.TicketEventPublisher;
import com.berryjelly.ticket_service.model.apimodel.TicketAssignmentRequest;
import com.berryjelly.ticket_service.model.businessobject.TicketBo;
import com.berryjelly.ticket_service.service.TicketCreationService;
import com.berryjelly.ticket_service.service.TicketSearchService;
import com.berryjelly.ticket_service.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketCreationService ticketCreationService;
    private final TicketSearchService ticketSearchService;
    private final TicketEventPublisher ticketAssignmentEventPublisher;

    public TicketServiceImpl(TicketCreationService ticketCreationService, TicketSearchService ticketSearchService,
                             TicketEventPublisher ticketAssignmentEventPublisher) {
        this.ticketCreationService = ticketCreationService;
        this.ticketSearchService = ticketSearchService;
        this.ticketAssignmentEventPublisher = ticketAssignmentEventPublisher;
    }

    @Override
    public TicketBo save(TicketBo ticketBo) {
        return ticketCreationService.createTicket(ticketBo);
    }

    @Override
    public TicketBo findByResourceId(String resourceId) {
        return ticketSearchService.findByResourceId(resourceId);
    }

    @Override
    public List<TicketBo> findAll() {
        return null;
    }

    @Override
    public void assign(TicketAssignmentRequest request) {
        ticketAssignmentEventPublisher.publishTicketAssignedEvent(request);
    }
}
