package ru.example.application.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ROLE")
public class Role {

    public Role() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME_ROLE")
    private String nameRole;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "CLIENT_ROLE",
            joinColumns = @JoinColumn(name = "ROLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "NAME_CLIENT"))
    private List<Client> clients;

   /* public Long getId() {
        return id;
    }
*/
    public void setId(Long id) {
        this.id = id;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }
}
