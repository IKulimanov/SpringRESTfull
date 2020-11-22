package ru.example.application.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.json.JSONException;
import org.json.JSONObject;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.example.application.dao.ClientRoleDAO;
import ru.example.application.dto.ClientDTO;
import ru.example.application.entity.Client;
import ru.example.application.entity.Role;
import ru.example.application.err.ErrorClient;
import ru.example.application.mappers.ClientMapper;
import ru.example.application.service.IClientRoleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class ClientRoleController {


    private IClientRoleService service;
    @Autowired
    public ClientRoleController(IClientRoleService service) {
        this.service = service;
    }

    @GetMapping("/getClients")
    public ResponseEntity<List<Client>> getAllClients(){
        final List<Client> clients =  service.readAll();
        return clients != null && !clients.isEmpty()
                ? new ResponseEntity<>(clients,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/getClient/{login}")
    public ResponseEntity<ClientDTO> getClientByLogin(@PathVariable(name = "login") String login){
        Client client =  service.findClientByLogin(login);
        ClientDTO clientDTO = ClientMapper.INSTANCE.toDTO(client);
        return clientDTO != null
                ? new ResponseEntity<>(clientDTO,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addClient")
    public ResponseEntity<?> addClient(@RequestBody Client client) throws JSONException {
        final List<ErrorClient> errorClients = service.addClient(client);
        JSONObject jsonObject = new JSONObject();
        if(errorClients.isEmpty())
        {
            jsonObject.put("success",true);
            return new ResponseEntity<>(jsonObject.toString(),HttpStatus.CREATED);
        }
        else
        {
            jsonObject.put("success", false);
            JSONObject errors = new JSONObject();
            for(ErrorClient reqErrs :errorClients) {
                errors.put(reqErrs.getType(), reqErrs.getName());
            }
            jsonObject.put("errors", errors);
            return new ResponseEntity<>(jsonObject.toString(),HttpStatus.BAD_REQUEST);
        }
        //return new ResponseEntity<>(jsonObject.toString(),HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/client/{login}")
    public ResponseEntity<Client> updateClient(Client client){

        return null;
    }

    @DeleteMapping("/client/{login}")
    public ResponseEntity<?> deleteClient(@PathVariable(name = "login") String login) throws JSONException {
        final boolean delete = service.delete(login);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success",delete);
        return delete
                ? new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK)
                : new ResponseEntity<>(jsonObject.toString(), HttpStatus.NOT_FOUND);

    }

}
