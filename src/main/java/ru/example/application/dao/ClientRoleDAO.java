package ru.example.application.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.example.application.entity.Client;
import ru.example.application.entity.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Transactional
@Repository
public class ClientRoleDAO implements IClientRoleDAO{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Client> findAllClient() {
        String hql = "select nameClient,login,password from Client ";
        return (List<Client>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Client findClientByLogin(String loginClient) {
        return entityManager.find(Client.class, loginClient);
    }

    @Override
    public boolean addClient(Client client) {
        Client client1 = new Client();
        client1.setNameClient(client.getNameClient());
        client1.setLogin(client.getLogin());
        client1.setPassword(client.getPassword());


        Set<Role> rol = client.getRoles();
        Role ro;
        Iterator<Role> iterator = rol.iterator();
        System.out.println("DOOOOOO");
        while(iterator.hasNext()){
            System.out.println("DOOOOO1");
            ro = iterator.next();
            System.out.println("DOOOOO2");
            System.out.println(ro.getNameRole());
            if (!entityManager.contains(ro)){
                System.out.println("DOOOOO3");
                client1.addRole(ro);
            }
        }
        System.out.println("POSLEEEEEEEEEEEEEEE");
        if (findClientByLogin(client1.getLogin()) == null){
            entityManager.persist(client1);
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public boolean updateClient(Client client) {

        return false;
    }

    @Override
    public boolean removeClient(String loginClient) {
        if (findClientByLogin(loginClient) != null) {
            entityManager.remove(findClientByLogin(loginClient));
            return true;
        }
        else
        {
            return false;
        }
    }
}
