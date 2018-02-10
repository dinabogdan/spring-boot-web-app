package com.freesoft.springboot.web.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.freesoft.springboot.web.jpa.entities.User;
import com.freesoft.springboot.web.jpa.repositories.UserRepository;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserCommandLineRunner.class);

	@Autowired
	private UserRepository repository;

	@Override
	public void run(String... arg0) throws Exception {
		repository.save(new User("Adam", "Admin"));
		repository.save(new User("John", "User"));
		repository.save(new User("Tom", "Admin"));
		repository.save(new User("Bill", "User"));

		for (User user : repository.findAll()) {
			LOGGER.info(user.toString());
		}
	}

}
