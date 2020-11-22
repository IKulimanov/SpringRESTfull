package ru.example.application.dto;


import ru.example.application.entity.Role;

import java.util.HashSet;
import java.util.Set;


public class ClientDTO {

    private String nameClient;
    private String login;
    private String password;
    private Set<RoleDTO> roles;

    public ClientDTO() {
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
    }
}
