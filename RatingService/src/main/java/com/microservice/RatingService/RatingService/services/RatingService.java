package com.microservice.RatingService.RatingService.services;

import com.microservice.RatingService.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating add(Rating rating);

    List<Rating> getAll();

    List<Rating> getRatingsByUsrId(String userId);

    List<Rating> getRatingsByHotelId(String hotelId);
}
