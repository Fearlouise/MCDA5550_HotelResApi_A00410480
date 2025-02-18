package com.example.MCDAHotelApi.model;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "hotels")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class HotelModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    private String address;
    @NotNull
    private double pricePerNight;
}
