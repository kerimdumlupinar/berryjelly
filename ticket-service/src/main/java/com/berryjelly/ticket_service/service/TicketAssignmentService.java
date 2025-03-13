package com.berryjelly.ticket_service.service;

import com.berryjelly.ticket_service.model.apimodel.TicketAssignmentRequest;
import com.berryjelly.ticket_service.model.businessobject.TicketBo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketAssignmentService {

    void assignTicketToUsers(TicketAssignmentRequest request);

}
