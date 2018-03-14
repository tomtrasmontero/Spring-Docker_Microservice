package com.example.usersapi.repositories;

import com.example.usersapi.models.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;

@SpringBootApplication
public interface UserRepository extends CrudRepository<User, Long> {

}