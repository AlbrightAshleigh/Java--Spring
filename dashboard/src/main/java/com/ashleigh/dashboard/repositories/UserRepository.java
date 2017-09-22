package com.ashleigh.dashboard.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ashleigh.dashboard.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{
	User findByUsername(String username);
}
