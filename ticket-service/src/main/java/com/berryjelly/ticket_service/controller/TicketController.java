package com.berryjelly.ticket_service.controller;

import com.berryjelly.ticket_service.mapper.TicketApiModelMapper;
import com.berryjelly.ticket_service.model.apimodel.TicketRequest;
import com.berryjelly.ticket_service.model.businessobject.TicketBo;
import com.berryjelly.ticket_service.service.TicketService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;
    private final TicketApiModelMapper ticketApiModelMapper;

    public TicketController(TicketService ticketService, TicketApiModelMapper ticketApiModelMapper) {
        this.ticketService = ticketService;
        this.ticketApiModelMapper = ticketApiModelMapper;
    }

    @GetMapping("/{resourceId}")
    public TicketBo getTicket(@PathVariable String resourceId){
        return ticketService.findByResourceId(resourceId);
    }

    @PostMapping
    public TicketBo saveTicket(@RequestBody TicketRequest request){
        return ticketService.save(ticketApiModelMapper.mapApiModelToBo(request));
    }
}
