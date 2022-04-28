package org.keepcode.service;

import org.keepcode.dto.CreateTicketDTO;
import org.keepcode.dto.TicketDTO;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface TicketService {

    List<TicketDTO> getAllTicketsByClient(Long client_id);

    List<TicketDTO> getAllTickets();

    TicketDTO getTicket(Long order_id);

    TicketDTO update(Long order_id, TicketDTO ticketDTO);

    TicketDTO save(User user, CreateTicketDTO createTicketDTO);
}
