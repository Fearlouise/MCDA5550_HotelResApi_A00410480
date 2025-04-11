package com.example.MCDAHotelApi.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "guests")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")  // Serialize only by ID
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
    @JsonIdentityReference(alwaysAsId = true)  // Serialize only reservation ID
    private ReservationModel reservation;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIdentityReference(alwaysAsId = true)  // Serialize only customer ID
    private CustomerModel customer;
}