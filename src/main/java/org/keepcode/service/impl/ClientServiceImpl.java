package org.keepcode.service.impl;

import lombok.RequiredArgsConstructor;
import org.keepcode.dto.ClientDTO;
import org.keepcode.entity.Client;
import org.keepcode.entity.Subscriber;
import org.keepcode.exception.clientException.NotExistClientException;
import org.keepcode.mapper.ClientMapper;
import org.keepcode.repository.ClientRepository;
import org.keepcode.service.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ClientDTO> getListClient() {
        List<Client> client;
        try {
            client = clientRepository.findAll();
        } catch (NullPointerException exception) {
            throw new NotExistClientException("Not exist clients");
        }
        return client.stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Client save(Subscriber subscriber, String name) {
        Client client = getClientByEmail(subscriber.getEmail());
        if (client == null) {
            client = new Client();
            client.setClientName(name);
            client.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
            client.setSubscriber(subscriber);
        }
        return clientRepository.save(client);
    }

    private Client getClientByEmail(String email) {
        Optional<Client> client = clientRepository.findClientBySubscriberEmail(email);
        return client.orElse(null);
    }


}
