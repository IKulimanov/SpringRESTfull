package ru.example.application.entity;

import javax.persistence.*;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Persister;

@Entity
@Table(name = "CLIENT")
public class Client {

    public Client() {
    }


    @Column(name = "NAME_CLIENT")
    private String nameClient;

    @Id
    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;


    //@JsonIgnore
    @ManyToMany( fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, })
    @JoinTable(name = "CLIENT_ROLE",
            joinColumns = @JoinColumn(name = "LOGIN_CLIENT"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role){
        System.out.println("VNUTRI1");
        if (!getRoles().contains(role)){
            getRoles().add(role);
            role.addClient(this);
        }
    }
/*
    public void addRole(Role role){
            roles.add(role);
            role.getClients().add(this);
    }
*/
    public void removeRole(Role role){
        roles.remove(role);
        role.getClients().remove(this);
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(nameClient, client.nameClient) &&
                Objects.equals(login, client.login) &&
                Objects.equals(password, client.password) &&
                Objects.equals(roles, client.roles);
    }
/*
    @Override
    public int hashCode() {
        return Objects.hash(nameClient, login, password, roles);
    }*/
}
