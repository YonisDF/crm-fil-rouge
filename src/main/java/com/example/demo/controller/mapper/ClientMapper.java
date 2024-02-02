package com.example.demo.controller.mapper;

import com.example.demo.controller.dto.ClientDTO;
import com.example.demo.model.Client;
import com.example.demo.model.state.ClientEnum;

public class ClientMapper {

    public static ClientDTO convertEntityToDTO(Client client) {
        ClientDTO dto = new ClientDTO();
        dto.setFirstName(client.getFirstName());
        dto.setLastName(client.getLastName());
        dto.setAddress(client.getAddress());
        dto.setCity(client.getCity());
        dto.setCompany(client.getCompany());
        dto.setCountry(client.getCountry());
        dto.setEmail(client.getEmail());
        dto.setZipCode(client.getZipCode());
        dto.setPhone(client.getPhone());

        String state = String.valueOf(ClientEnum.values()[client.getState()]);
        dto.setState(state);
        return dto;
    }

    public static Client convertDTOtoEntity(ClientDTO dto) {
        Client client = new Client();
        client.setFirstName(dto.getFirstName());
        client.setLastName(dto.getLastName());
        client.setAddress(dto.getAddress());
        client.setPhone(dto.getPhone());
        client.setCountry(dto.getCountry());
        client.setCity(dto.getCity());
        client.setCompany(dto.getCompany());
        client.setEmail(dto.getEmail());
        client.setZipCode(dto.getZipCode());

        if (dto.getState() != null) {
            short intState = (short) ClientEnum.valueOf(dto.getState()).ordinal();
            client.setState(intState);
        }
        return client;
    }
}
