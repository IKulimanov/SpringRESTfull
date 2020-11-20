package ru.example.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.example.application.entity.Client;
import ru.example.application.service.IClientRoleService;

import java.util.List;

@RestController
public class ClientRoleController {

    private IClientRoleService service;
    @Autowired
    public ClientRoleController(IClientRoleService service) {
        this.service = service;
    }

  /*  @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }*/

    @GetMapping("/getClients")
    public List<Client> getAllClients(){
        return service.readAll();
    }

    @GetMapping("/getClient/{login}")
    public Client getClientByName(@PathVariable(name = "login") String login){
        return service.read(login);
    }
/*
    @PostMapping
    public Client addClient(Client client) {
        return null;
    }

    @PostMapping
    public Client getClientByName(String clientName){
        return null;
    }

    @PutMapping
    public Client updateClient(Client client){
        return null;
    }

    @DeleteMapping
    public void deleteClient(String clientName){

    }*/
}
