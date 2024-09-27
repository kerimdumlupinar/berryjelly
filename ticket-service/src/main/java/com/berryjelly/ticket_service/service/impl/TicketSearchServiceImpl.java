package com.berryjelly.ticket_service.service.impl;

import com.berryjelly.ticket_service.mapper.TicketEntityMapper;
import com.berryjelly.ticket_service.model.businessobject.TicketBo;
import com.berryjelly.ticket_service.model.entity.TicketEntity;
import com.berryjelly.ticket_service.repository.TicketRepository;
import com.berryjelly.ticket_service.service.TicketSearchService;
import org.springframework.stereotype.Service;

@Service
public class TicketSearchServiceImpl implements TicketSearchService {

    private final TicketRepository ticketRepository;
    private final TicketEntityMapper ticketEntityMapper;

    public TicketSearchServiceImpl(TicketRepository ticketRepository, TicketEntityMapper ticketEntityMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketEntityMapper = ticketEntityMapper;
    }

    @Override
    public TicketBo findByResourceId(String resourceId) {
        TicketEntity ticketEntity = ticketRepository.findByResourceId(resourceId).orElse(null);
        return ticketEntityMapper.mapEntityToBo(ticketEntity);
    }
}
