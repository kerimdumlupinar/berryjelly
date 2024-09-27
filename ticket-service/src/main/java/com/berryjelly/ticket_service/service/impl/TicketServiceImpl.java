package com.berryjelly.ticket_service.service.impl;

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

    public TicketServiceImpl(TicketCreationService ticketCreationService, TicketSearchService ticketSearchService) {
        this.ticketCreationService = ticketCreationService;
        this.ticketSearchService = ticketSearchService;
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
}
