package com.berryjelly.ticket_service.service;

import com.berryjelly.ticket_service.model.businessobject.TicketBo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {

    TicketBo save(TicketBo ticketBo);
    TicketBo findByResourceId(String resourceId);
    List<TicketBo> findAll();

}
