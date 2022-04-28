package org.keepcode.service;

import org.keepcode.dto.ClientDTO;
import org.keepcode.entity.Client;
import org.keepcode.entity.Subscriber;

import java.util.List;

public interface ClientService {

    List<ClientDTO> getListClient();

    Client save(Subscriber subscriber, String name);
}
