package com.example.usersapi.repositories;

import com.example.usersapi.models.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> getByid(Long newId);

    Optional<User> findByuserName(String userName);
}