package ru.example.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import ru.example.application.dao.IClientRoleDAO;
import ru.example.application.entity.Client;
import ru.example.application.err.ErrorClient;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ClientRoleServiceImpl implements IClientRoleService {

    @Autowired
    private IClientRoleDAO clientDAO;

    @Override
    public List<Client> readAll() {
        return clientDAO.findAllClient();
    }

    @Override
    public Client findClientByLogin(String loginClient) {
        return clientDAO.findClientByLogin(loginClient);
    }

    @Override
    public List<ErrorClient> addClient(Client client) {
        List<ErrorClient> errorClients = new ArrayList<>();

        Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$");
        Matcher login = pattern.matcher(client.getLogin());
        Matcher nameClient = pattern.matcher(client.getNameClient());
        pattern = Pattern.compile("(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])");
        Matcher password = pattern.matcher(client.getPassword());
        System.out.println("PASSWORD " + client.getPassword());
        if (!login.find()){
            errorClients.add(new ErrorClient("loginErr","Логин не должен быть пустым и не должен содержать спец.символы"));
        }
        if (!nameClient.find()){
            errorClients.add(new ErrorClient("nameErr","Имя не должно быть пустым и не должно содержать спец.символы"));
        }
        if (!password.find()) {
            errorClients.add(new ErrorClient("passwordErr","Пароль не корректный"));
        }
        if (errorClients.isEmpty())
        {
            if (!clientDAO.addClient(client))
            {
                errorClients.add(new ErrorClient("clientErr","Пользователь с таким логином существует"));
            }
        }
        return errorClients;
    }

    @Override
    public boolean update(Client client) {
        return false;
    }

    @Override
    public boolean delete(String loginClient) {
       return clientDAO.removeClient(loginClient);


    }
}
