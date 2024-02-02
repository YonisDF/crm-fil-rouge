package com.example.demo.controller;

import com.example.demo.controller.dto.ClientDTO;
import com.example.demo.controller.mapper.ClientMapper;
import com.example.demo.model.Client;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.demo.dao.ValidateData.isAnyStringBlank;
import static com.example.demo.dao.ValidateData.isStringInClientEnum;

@RestController
@RequestMapping("crm")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("clients")
    public ResponseEntity<List<ClientDTO>> getClients() {
        List<ClientDTO> listClientDTO = new ArrayList<>();
        for (Client client : clientService.getAll()) {
            listClientDTO.add(ClientMapper.convertEntityToDTO(client));
        }
        return ResponseEntity.ok(listClientDTO);
    }

    @GetMapping("clients/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable("id") Integer id) {
        Optional<Client> optional = clientService.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Client client = optional.get();
            ClientDTO clientDTO = ClientMapper.convertEntityToDTO(client);
            return ResponseEntity.ok(clientDTO);
        }
    }

    @PostMapping("clients")
    public ResponseEntity<?> addClient(@RequestBody ClientDTO clientDTO) {
        if (isAnyStringBlank(clientDTO.getCompany(), clientDTO.getFirstName(), clientDTO.getLastName(), clientDTO.getEmail(),
                clientDTO.getPhone(), clientDTO.getAddress(), clientDTO.getZipCode(), clientDTO.getCity(), clientDTO.getCountry(), clientDTO.getState())
                || !isStringInClientEnum(clientDTO.getState())) {
            return ResponseEntity.badRequest().build();
        } else {
            Client client = ClientMapper.convertDTOtoEntity(clientDTO);
            clientService.add(client);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }

    @DeleteMapping("clients/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable("id") Integer id) {
        Optional<Client> optional = clientService.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            clientService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
    }

    @PutMapping("clients/{id}")
    public ResponseEntity<?> modifyClient(@PathVariable("id") Integer id, @RequestBody ClientDTO clientDTO) {
        Optional<Client> optional = clientService.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else if (isAnyStringBlank(clientDTO.getCompany(), clientDTO.getFirstName(), clientDTO.getLastName(), clientDTO.getEmail(),
                clientDTO.getPhone(), clientDTO.getAddress(), clientDTO.getZipCode(), clientDTO.getCity(), clientDTO.getCountry(), clientDTO.getState())
                || !isStringInClientEnum(clientDTO.getState())) {
            return ResponseEntity.badRequest().build();
        } else {
            Client client = ClientMapper.convertDTOtoEntity(clientDTO);
            client.setId(id);
            clientService.update(client);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
    }
}
