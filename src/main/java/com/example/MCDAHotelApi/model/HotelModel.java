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
    private String streetNumber;
    private String streetName;
    @NotNull
    private String city;
    private String province;
    @NotNull
    private String country;
    private String postalCode;
    @NotNull
    private double pricePerNight;
}
