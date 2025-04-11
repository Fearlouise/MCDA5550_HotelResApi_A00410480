package com.example.MCDAHotelApi.model;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "guests")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String Name;

    @NotNull
    private String gender;

    @ManyToOne
    @JoinColumn(name = "reservation_id", nullable = false)
    private ReservationModel reservation;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerModel customer;
}