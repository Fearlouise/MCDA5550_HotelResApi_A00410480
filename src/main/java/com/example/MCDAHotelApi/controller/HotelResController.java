package com.example.MCDAHotelApi.controller;

import com.example.MCDAHotelApi.model.HotelModel;
import com.example.MCDAHotelApi.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelResController {
    private final HotelService hotelService;
    public HotelResController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    @GetMapping
    public List<HotelModel> getAllHotels() {
        return hotelService.getAllHotels();
    }
    @PostMapping
    public ResponseEntity<?> addHotel(@Valid @RequestBody HotelModel hotelModel) {
        if (hotelModel.getHotelName() == null || hotelModel.getCity() == null || hotelModel.getCountry() == null) {
            return ResponseEntity.badRequest().body("Missing one or more required fields: hotelName, city, country");
        }
        return ResponseEntity.ok(hotelService.addHotel(hotelModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable Long id) {
        boolean deleted = hotelService.deleteHotel(id);
        if (deleted) {
            return ResponseEntity.ok("Hotel deleted");
        } else {
            return ResponseEntity.status(404).body("Hotel not found");
        }
    }
}
