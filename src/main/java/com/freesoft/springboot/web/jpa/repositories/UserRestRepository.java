package com.freesoft.springboot.web.jpa.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.freesoft.springboot.web.jpa.entities.User;

@RepositoryRestResource(path="users", collectionResourceRel="users")
public interface UserRestRepository extends PagingAndSortingRepository<User, Long> {
	
	List<User> findByRole(@Param("role") String role);

}
