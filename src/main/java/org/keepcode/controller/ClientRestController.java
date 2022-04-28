package org.keepcode.controller;

import lombok.RequiredArgsConstructor;
import org.keepcode.dto.ClientDTO;
import org.keepcode.dto.TicketDTO;
import org.keepcode.service.ClientService;
import org.keepcode.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientRestController {

    private final ClientService clientService;
    private final TicketService ticketService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/date")
    public ResponseEntity<Map<ClientDTO, List<TicketDTO>>> getAllClientAndOrders() {
        Map<ClientDTO, List<TicketDTO>> clientAndOrders = new HashMap<>();
        List<ClientDTO> clientsDTO = clientService.getListClient();
        for (ClientDTO client : clientsDTO) {
            clientAndOrders.put(client, ticketService.getAllTicketsByClient(client.getId()));
        }
        return new ResponseEntity<>(clientAndOrders, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClient() {
        return new ResponseEntity<>(clientService.getListClient(), HttpStatus.OK);
    }


}
