package com.microservice.HotelService.HotelService.services;

import com.microservice.HotelService.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {

    Hotel add(Hotel hotel);

    List<Hotel> getAll();

    Hotel getHotelById(String hotelId);
}
