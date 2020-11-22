package ru.example.application.dto;

import ru.example.application.entity.Client;

import java.util.Set;

public class RoleDTO {
    private Long id;
    private String nameRole;
    //private Set<Client> clients;

    public RoleDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    /*public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }*/
}
