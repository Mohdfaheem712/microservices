package com.microservice.HotelService.HotelService.controllers;

import com.microservice.HotelService.HotelService.entities.Hotel;
import com.microservice.HotelService.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    HotelService hotelService;

    @GetMapping
    public List<Hotel> getAllHotels(){
        return hotelService.getAll();
    }

    @GetMapping("/{hotelId}")
    public Hotel getHotelById(@PathVariable String hotelId){
        return hotelService.getHotelById(hotelId);
    }

    @PostMapping
    public Hotel add(@RequestBody Hotel hotel){
        return hotelService.add(hotel);
    }
}
