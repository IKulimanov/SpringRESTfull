package ru.example.application.dao;

import ru.example.application.entity.Client;

import java.util.List;

public interface IClientRoleDAO {
    /**
     * Получение всех пользователей
     * @return Список клиентов
     */
    List<Client> findAllClient();

    /**
     * Получение пользователя с ролью по логину
     * @param loginClient логин пользователя
     * @return пользователь с ролью
     */
    Client findClientByLogin(String loginClient);

    /**
     * Добавление пользователя и роль
     * @param client пользователь с ролью
     */
    boolean addClient(Client client);

    /**
     * Редактирование пользователя и изменение его ролей
     * @param client пользователь с ролью
     * @return
     */
    boolean updateClient(Client client);

    /**
     * Удаление пользователя по логину
     * @param loginClient логин пользователя
     * @return
     */
    boolean removeClient(String loginClient);
}
