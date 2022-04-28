package org.keepcode.mapper;

import org.keepcode.dto.TicketDTO;
import org.keepcode.entity.Ticket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    Ticket toEntity(TicketDTO ticketDTO);

    TicketDTO toDto(Ticket ticket);
}
