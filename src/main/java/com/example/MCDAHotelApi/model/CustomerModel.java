package com.example.MCDAHotelApi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto-generated customer ID

    @NotNull
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<ReservationModel> reservations;

    @OneToMany(mappedBy = "customer")
    private List<GuestModel> guests;

    @JsonIgnore
    public List<ReservationModel> getReservations() {
        return reservations;
    }
}