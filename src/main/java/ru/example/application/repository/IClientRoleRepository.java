package ru.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.application.entity.Client;

@Repository
public interface IClientRoleRepository extends JpaRepository<Client, String> {

}
