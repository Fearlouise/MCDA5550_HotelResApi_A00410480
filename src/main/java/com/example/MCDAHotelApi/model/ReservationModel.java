package com.example.MCDAHotelApi.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "reservations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String reservationNumber;

    @NotNull
    private LocalDate checkInDate;

    @NotNull
    private LocalDate checkOutDate;

    @NotNull
    private int numberOfGuests;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private HotelModel hotel;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CustomerModel customer;

    @JsonIgnore
    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<GuestModel> guests;

    @PrePersist
    public void generateReservationNumber() {
        this.reservationNumber = "RES-" + UUID.randomUUID().toString();
    }
}
