package com.example.MCDAHotelApi.controller;

import com.example.MCDAHotelApi.model.HotelModel;
import com.example.MCDAHotelApi.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<HotelModel> addHotel (@RequestBody HotelModel hotel) {
        return ResponseEntity.ok(hotelService.addHotel(hotel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HotelModel> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.noContent().build();
    }
}
