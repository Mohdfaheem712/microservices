package com.microservice.UserMicroservice.services;

import com.microservice.UserMicroservice.entities.User;
import java.util.List;

public interface UserService {

    User add(User user);

    List<User> getAll();

    User getUserById(String userId);

}
