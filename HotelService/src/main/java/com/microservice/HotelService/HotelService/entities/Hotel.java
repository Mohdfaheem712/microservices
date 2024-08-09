package com.microservice.HotelService.HotelService.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="hotel")
public class Hotel {
    @Id
    @Column(name="id")
    public String hotelId;
    @Column(name="name", length = 55)
    public String name;
    @Column(name="location")
    private String location;
    @Column(name="about")
    private String about;
}
