package com.freesoft.springboot.web.jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import com.freesoft.springboot.web.jpa.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
