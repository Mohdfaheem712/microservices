package com.microservice.HotelService.HotelService.services.impl;

import com.microservice.HotelService.HotelService.entities.Hotel;
import com.microservice.HotelService.HotelService.exceptions.ResourceNotFoundException;
import com.microservice.HotelService.HotelService.repositories.HotelRepository;
import com.microservice.HotelService.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel add(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setHotelId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel Not foudn by given id"+hotelId));
    }
}
