package com.microservice.UserMicroservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "micro_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @Column(name = "ID")
    private String userId;

    @Column(name = "NAME", length = 155)
    private String name;

    @Column(name = "EMAIL", length = 155)
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Transient
    private List<Rating> ratings =  new ArrayList<>();
}
