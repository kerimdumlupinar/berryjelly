package com.berryjelly.ticket_service.service;

import com.berryjelly.ticket_service.model.businessobject.TicketBo;
import org.springframework.stereotype.Service;

@Service
public export TicketSearchService {

    TicketBo findByResourceId(String resourceId);
}
