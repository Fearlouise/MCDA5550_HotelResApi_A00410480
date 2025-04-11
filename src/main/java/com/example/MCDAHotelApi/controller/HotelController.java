package com.example.MCDAHotelApi.controller;

import com.example.MCDAHotelApi.model.HotelModel;
import com.example.MCDAHotelApi.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<HotelModel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelModel> getHotelById(@PathVariable Long id) {
        Optional<HotelModel> hotel = hotelService.getHotelById(id);
        return hotel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HotelModel> createHotel(@RequestBody HotelModel hotelModel) {
        HotelModel createdHotel = hotelService.createHotel(hotelModel);
        return ResponseEntity.status(201).body(createdHotel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable Long id) {
        boolean isDeleted = hotelService.deleteHotel(id);
        return isDeleted ? ResponseEntity.ok("Hotel deleted successfully") : ResponseEntity.notFound().build();
    }
}
