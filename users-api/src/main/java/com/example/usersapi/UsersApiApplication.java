package com.example.usersapi;

import com.example.usersapi.models.User;
import com.example.usersapi.repositories.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class UsersApiApplication {
//
//	@RequestMapping("/")
//	public String home() {
//		return "some users";
//	}

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/")
	public Iterable<User> findAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/{userId}")
	public List<User> findUserById(@PathVariable Long userId) {

		System.out.println();
		return userRepository.getByid(userId);

	}

	@GetMapping("/2/{firstName}")
	public Optional<User> findUserByName(@PathVariable String firstName) {
		System.out.println();
		return userRepository.findByuserName(firstName);
	}

	@DeleteMapping("/{userId}")
	public HttpStatus deleteById(@PathVariable Long userId) {
		userRepository.delete(userId);
		System.out.println("deleted" + userId);
		return HttpStatus.OK;
	}

	public static void main(String[] args) {
		SpringApplication.run(UsersApiApplication.class, args);
	}
}
