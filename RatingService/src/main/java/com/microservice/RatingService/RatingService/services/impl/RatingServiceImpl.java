package com.microservice.RatingService.RatingService.services.impl;

import com.microservice.RatingService.RatingService.entities.Rating;
import com.microservice.RatingService.RatingService.repositories.RatingRepository;
import com.microservice.RatingService.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Rating add(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAll() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingsByUsrId(String userId) {
        List<Rating> ratings = ratingRepository.findByUserId(userId);
        return ratings;
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
