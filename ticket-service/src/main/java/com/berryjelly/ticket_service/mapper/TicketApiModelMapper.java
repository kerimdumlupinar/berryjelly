package com.berryjelly.ticket_service.mapper;

import com.berryjelly.ticket_service.model.apimodel.TicketRequest;
import com.berryjelly.ticket_service.model.businessobject.TicketBo;
import org.mapstruct.Mapper;

@Mapper(implementationName = "TicketApiModelMapperImpl")
public abstract class TicketApiModelMapper {

    public abstract TicketBo mapApiModelToBo(TicketRequest request);

    public abstract TicketRequest mapBoToApiModel(TicketBo ticketBo);
}
