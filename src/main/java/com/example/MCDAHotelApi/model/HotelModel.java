package com.example.MCDAHotelApi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hotels")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class HotelModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private double pricePerNight;
}
