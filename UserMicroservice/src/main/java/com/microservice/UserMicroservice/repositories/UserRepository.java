package com.microservice.UserMicroservice.repositories;

import com.microservice.UserMicroservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
