package com.demo.firstjwt;

import com.demo.firstjwt.entity.User;
import com.demo.firstjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class FirstJwtApplication {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void initUsers(){
		List<User> users= Stream.of(
				new User(101, "user1", "pwd1", "user1@gmail.com"),
				new User(102, "user2", "pwd2", "user2@gmail.com"),
				new User(103, "cr7", "password", "cr7@gmail.com"),
				new User(104, "cristianoronaldo", "cristianoronaldo", "cristianoronaldo@gmail.com")


		).collect(Collectors.toList());
		repository.saveAll(users);
	}


	public static void main(String[] args) {
		SpringApplication.run(FirstJwtApplication.class, args);
	}

}
