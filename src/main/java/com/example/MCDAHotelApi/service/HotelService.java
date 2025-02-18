package com.example.MCDAHotelApi.service;

import com.example.MCDAHotelApi.model.HotelModel;
import com.example.MCDAHotelApi.repository.HotelRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class HotelService {
    private final HotelRepository hotelRepository;
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }
    public List<HotelModel> getAllHotels() {
        return hotelRepository.findAll();
    }
    public HotelModel addHotel (HotelModel hotel) {
        return hotelRepository.save(hotel);
    }
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }

}
