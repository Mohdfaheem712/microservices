package com.microservice.UserMicroservice.services.impl;

import com.microservice.UserMicroservice.entities.Hotel;
import com.microservice.UserMicroservice.entities.Rating;
import com.microservice.UserMicroservice.entities.User;
import com.microservice.UserMicroservice.exceptions.ResourceNotFoundException;
import com.microservice.UserMicroservice.repositories.UserRepository;
import com.microservice.UserMicroservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public User add(User user) {
        String randomId = UUID.randomUUID().toString();
        user.setUserId(randomId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given Id not found "+userId));
        Rating[] ratingsOfUser = restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getUserId(), Rating[].class);
        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
        List<Rating> ratingsList = ratings.stream().map(rating->{
            String hotelId = rating.getHotelId();
            ResponseEntity<Hotel> hotelEntity =  restTemplate.getForEntity("http://localhost:8082/hotels/"+hotelId,Hotel.class);
            Hotel hotel = hotelEntity.getBody();
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratings);
        return user;
    }
}
