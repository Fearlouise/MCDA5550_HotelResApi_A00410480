package com.example.MCDAHotelApi.service;

import com.example.MCDAHotelApi.model.HotelModel;
import com.example.MCDAHotelApi.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<HotelModel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Optional<HotelModel> getHotelById(Long id) {
        return hotelRepository.findById(id);
    }

    public HotelModel createHotel(HotelModel hotelModel) {
        return hotelRepository.save(hotelModel);
    }

    public boolean deleteHotel(Long id) {
        if (hotelRepository.existsById(id)) {
            hotelRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
