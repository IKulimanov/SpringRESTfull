package ru.example.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.application.entity.Client;
import ru.example.application.repository.IClientRoleRepository;

import java.util.List;

@Service
public class ClientRoleServiceImpl implements IClientRoleService {

    @Autowired
    private IClientRoleRepository repository;

    @Override
    public List<Client> readAll() {
        return repository.findAll();
    }

    @Override
    public Client read(String loginClient) {
        return repository.findById(loginClient).orElse(null);
    }

    @Override
    public void addClient(Client client) {

    }

    @Override
    public boolean update(Client client) {
        return false;
    }

    @Override
    public boolean delete(String loginClient) {
        return false;
    }
}
