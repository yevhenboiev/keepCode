package org.keepcode.service.impl;

import lombok.RequiredArgsConstructor;
import org.keepcode.dto.CreateTicketDTO;
import org.keepcode.dto.TicketDTO;
import org.keepcode.entity.Client;
import org.keepcode.entity.Subscriber;
import org.keepcode.entity.Ticket;
import org.keepcode.exception.ticketException.NotExistTicketException;
import org.keepcode.mapper.TicketMapper;
import org.keepcode.repository.TicketRepository;
import org.keepcode.service.ClientService;
import org.keepcode.service.SubscriberService;
import org.keepcode.service.TicketService;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketMapper ticketMapper;
    private final TicketRepository ticketRepository;
    private final SubscriberService subscriberService;
    private final ClientService clientService;

    @Transactional(readOnly = true)
    @Override
    public List<TicketDTO> getAllTicketsByClient(Long client_id) {
        List<TicketDTO> ordersDTO = ticketRepository.findAllByClientId(client_id).stream()
                .map(ticketMapper::toDto)
                .collect(Collectors.toList());
        checkEmptyOrders(ordersDTO);
        return ordersDTO;
    }

    @Transactional(readOnly = true)
    @Override
    public List<TicketDTO> getAllTickets() {
        List<TicketDTO> ordersDTO = ticketRepository.findAll().stream()
                .map(ticketMapper::toDto)
                .collect(Collectors.toList());
        checkEmptyOrders(ordersDTO);
        return ordersDTO;
    }

    @Transactional(readOnly = true)
    @Override
    public TicketDTO getTicket(Long ticket_id) {
        Optional<Ticket> order = ticketRepository.findById(ticket_id);
        if (!order.isPresent()) {
            throw new NotExistTicketException("Not found ticket by " + ticket_id);
        }
        return ticketMapper.toDto(order.get());
    }

    @Transactional
    @Override
    public TicketDTO update(Long ticket_id, TicketDTO ticketDTO) {
        getTicket(ticket_id);
        Ticket ticket = ticketMapper.toEntity(ticketDTO);
        ticket.setId(ticket_id);
        return ticketMapper.toDto(ticket);
    }

    @Transactional
    @Override
    public TicketDTO save(User user, CreateTicketDTO createTicketDTO) {
        Subscriber subscriber = subscriberService.getByEmail(user.getUsername());
        Client client = clientService.save(subscriber, createTicketDTO.getName());

        Ticket ticket = new Ticket();
        ticket.setClient(client);
        ticket.setValue(createTicketDTO.getValue());
        ticket.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));

        return ticketMapper.toDto(ticketRepository.save(ticket));
    }

    private void checkEmptyOrders(List<TicketDTO> ticketsDTO) {
        if (ticketsDTO.isEmpty()) {
            throw new NotExistTicketException("Not found tickets");
        }
    }
}
