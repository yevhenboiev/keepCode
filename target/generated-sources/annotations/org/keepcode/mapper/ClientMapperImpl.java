package org.keepcode.mapper;

import javax.annotation.Generated;
import org.keepcode.dto.ClientDTO;
import org.keepcode.entity.Client;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-28T16:20:58+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_311 (Oracle Corporation)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client toEntity(ClientDTO clientDto) {
        if ( clientDto == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( clientDto.getId() );
        client.setSubscriber( clientDto.getSubscriber() );
        client.setClientName( clientDto.getClientName() );
        client.setCreationDate( clientDto.getCreationDate() );

        return client;
    }

    @Override
    public ClientDTO toDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId( client.getId() );
        clientDTO.setClientName( client.getClientName() );
        clientDTO.setSubscriber( client.getSubscriber() );
        clientDTO.setCreationDate( client.getCreationDate() );

        return clientDTO;
    }
}
