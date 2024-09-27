package com.berryjelly.ticket_service.mapper;

import com.berryjelly.ticket_service.model.businessobject.TicketBo;
import com.berryjelly.ticket_service.model.entity.TicketEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(implementationName = "TicketEntityMapperImpl")
public abstract class TicketEntityMapper {

    public abstract TicketBo mapEntityToBo(TicketEntity entity);

    @Mapping(target = "id", ignore = true)
    public abstract TicketEntity mapBoToEntity(TicketBo bo);
}
