package com.example.demo.service;

import com.example.demo.dao.ClientRepository;
import com.example.demo.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public void add(Client client){
        clientRepository.save(client);
    }

    public List<Client> getAll(){
        return clientRepository.findAll();
    }

    public Optional<Client> findById(Integer id){
        return clientRepository.findById(id);
    }

    public void delete(Integer id){
        clientRepository.deleteById(id);
    }

    public void update(Client client){
        clientRepository.save(client);
    }
}
