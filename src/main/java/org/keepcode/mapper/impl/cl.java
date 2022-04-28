//package org.keepcode.mapper.impl;
//
//import org.keepcode.dto.ClientDTO;
//import org.keepcode.entity.Client;
//import org.keepcode.mapper.ClientMapper;
//
//public class ClientMapperImpl implements ClientMapper {
//    @Override
//    public Client toEntity(ClientDTO clientDto) {
//        if(clientDto == null) {
//            return null;
//        }
//
//        Client client = new Client();
//
//        client.setId_client(clientDto.getId_client());
//        client.setName(clientDto.getName());
//        client.setDate_creation(clientDto.getDate_creation());
//
//        return client;
//    }
//
//    @Override
//    public ClientDTO toDto(Client client) {
//        if(client == null) {
//            return null;
//        }
//
//        ClientDTO clientDto = new ClientDTO();
//        clientDto.setId_client(client.getId_client());
//        clientDto.setName(client.getName());
//        clientDto.setDate_creation(client.getDate_creation());
//
//        return clientDto;
//    }
//}
