package com.example.demo.controller;

import com.example.demo.model.Client;
import com.example.demo.model.state.ClientEnum;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.OK)
    public List<Client> getClients(){
        return clientService.getAll();
    }

    @GetMapping("clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") Integer id){
        Optional<Client> optional = clientService.findById(id);
        if (optional.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            Client client = optional.get();
            return ResponseEntity.ok(client);
        }
    }

    @PostMapping("clients")
    public ResponseEntity<?> addClient(@RequestBody Client client){
        if (isAnyStringBlank(client.getCompany(),client.getFirstName(),client.getLastName(),client.getEmail(),
                client.getPhone(),client.getAddress(),client.getZipCode(),client.getCity(),client.getCountry(),client.getState()) || !isStringInClientEnum(client.getState())){
            return ResponseEntity.badRequest().build();
        } else {
            clientService.add(client);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }
}
