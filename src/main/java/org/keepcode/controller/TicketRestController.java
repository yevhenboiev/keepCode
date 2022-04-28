package org.keepcode.controller;

import lombok.RequiredArgsConstructor;
import org.keepcode.dto.CreateTicketDTO;
import org.keepcode.dto.TicketDTO;
import org.keepcode.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class TicketRestController {

    private final TicketService ticketService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/orders/{client_id}")
    public ResponseEntity<List<TicketDTO>> getAllTicketsByClientId(@PathVariable("client_id") @NotNull Long client_id) {
        return new ResponseEntity<>(ticketService.getAllTicketsByClient(client_id), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<TicketDTO>> getAllTickets() {
        return new ResponseEntity<>(ticketService.getAllTickets(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<TicketDTO> updateTicket(@PathVariable("id") @NotNull Long orderId,
                                                   @Valid @RequestBody TicketDTO ticketDto) {
        TicketDTO updateTicketDTO = ticketService.update(orderId, ticketDto);
        return new ResponseEntity<>(updateTicketDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TicketDTO> getTicket(@PathVariable("id") @NotNull Long orderId) {
        TicketDTO updateTicketDTO = ticketService.getTicket(orderId);
        return new ResponseEntity<>(updateTicketDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<TicketDTO> createTicket(@AuthenticationPrincipal User user,
                                                  @Validated @RequestBody CreateTicketDTO createTicketDTO) {
        TicketDTO ticketDTO = ticketService.save(user, createTicketDTO);
        return new ResponseEntity<>(ticketDTO, HttpStatus.OK);
    }

}
