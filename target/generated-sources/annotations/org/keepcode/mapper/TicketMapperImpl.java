package org.keepcode.mapper;

import javax.annotation.Generated;
import org.keepcode.dto.TicketDTO;
import org.keepcode.entity.Ticket;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-28T16:20:58+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
@Component
public class TicketMapperImpl implements TicketMapper {

    @Override
    public Ticket toEntity(TicketDTO ticketDTO) {
        if ( ticketDTO == null ) {
            return null;
        }

        Ticket ticket = new Ticket();

        ticket.setId( ticketDTO.getId() );
        ticket.setClient( ticketDTO.getClient() );
        ticket.setValue( ticketDTO.getValue() );
        ticket.setCreationDate( ticketDTO.getCreationDate() );

        return ticket;
    }

    @Override
    public TicketDTO toDto(Ticket ticket) {
        if ( ticket == null ) {
            return null;
        }

        TicketDTO ticketDTO = new TicketDTO();

        ticketDTO.setId( ticket.getId() );
        ticketDTO.setClient( ticket.getClient() );
        ticketDTO.setValue( ticket.getValue() );
        ticketDTO.setCreationDate( ticket.getCreationDate() );

        return ticketDTO;
    }
}
