package com.example.MCDAHotelApi.controller;

import com.example.MCDAHotelApi.model.ReservationModel;
import com.example.MCDAHotelApi.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<ReservationModel> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationModel> getReservationById(@PathVariable Long id) {
        Optional<ReservationModel> reservation = reservationService.getReservationById(id);
        return reservation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ReservationModel> createReservation(@RequestBody ReservationModel reservationModel) {
        ReservationModel createdReservation = reservationService.createReservation(reservationModel);
        return ResponseEntity.status(201).body(createdReservation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable Long id) {
        boolean isDeleted = reservationService.deleteReservation(id);
        return isDeleted ? ResponseEntity.ok("Reservation deleted successfully") : ResponseEntity.notFound().build();
    }
}