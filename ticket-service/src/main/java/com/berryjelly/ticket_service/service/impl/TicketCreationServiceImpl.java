package com.berryjelly.ticket_service.service.impl;

import com.berryjelly.ticket_service.mapper.TicketEntityMapper;
import com.berryjelly.ticket_service.model.businessobject.AuditMetaDataBo;
import com.berryjelly.ticket_service.model.businessobject.TicketBo;
import com.berryjelly.ticket_service.model.businessobject.constants.TicketStatus;
import com.berryjelly.ticket_service.model.entity.TicketEntity;
import com.berryjelly.ticket_service.repository.TicketRepository;
import com.berryjelly.ticket_service.service.TicketCreationService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Locale;

@Service
public class TicketCreationServiceImpl implements TicketCreationService {

    private final TicketRepository ticketRepository;
    private final TicketEntityMapper ticketEntityMapper;

    public TicketCreationServiceImpl(TicketRepository ticketRepository, TicketEntityMapper ticketEntityMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketEntityMapper = ticketEntityMapper;
    }

    @Override
    public TicketBo createTicket(TicketBo ticketBo) {

        ticketBo.setStatus(TicketStatus.PENDING);
        String resourceId = RandomStringUtils.randomAlphanumeric(10).toUpperCase(Locale.ROOT);
        ticketBo.setResourceId(resourceId);
        ticketBo.setMeta(createAuditMetaDataBo());

        TicketEntity entity = ticketEntityMapper.mapBoToEntity(ticketBo);
        ticketRepository.save(entity);

        return ticketBo;
    }

    private AuditMetaDataBo createAuditMetaDataBo(){

        LocalDateTime now = LocalDateTime.now();
        AuditMetaDataBo meta = new AuditMetaDataBo();
        meta.setCreatedAt(now);

        return meta;
    }
}
