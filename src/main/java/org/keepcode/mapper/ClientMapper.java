package org.keepcode.mapper;

import org.keepcode.dto.ClientDTO;
import org.keepcode.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toEntity(ClientDTO clientDto);

    ClientDTO toDto(Client client);
}
