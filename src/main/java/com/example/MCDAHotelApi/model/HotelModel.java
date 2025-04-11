package com.example.MCDAHotelApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;  // Add this import

import java.util.List;

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
    @Column(name = "name", length = 100, nullable = false)
    private String hotelName;

    @Column(name = "address", length = 255, nullable = false)
    private String address;

    @Column(name = "city", length = 100, nullable = false)
    private String city;

    @Column(name = "province", length = 100, nullable = false)
    private String province;

    @Column(name = "postal_code", length = 20, nullable = false)
    private String postalCode;

    @JsonManagedReference
    @OneToMany(mappedBy = "hotel")
    private List<ReservationModel> reservations;

    @JsonIgnore  // Add this annotation
    public List<ReservationModel> getReservations() {
        return reservations;
    }
}






