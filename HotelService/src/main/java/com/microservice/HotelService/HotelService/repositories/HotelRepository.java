package com.microservice.HotelService.HotelService.repositories;

import com.microservice.HotelService.HotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {
}
