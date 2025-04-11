package com.example.MCDAHotelApi.service;

import com.example.MCDAHotelApi.model.GuestModel;
import com.example.MCDAHotelApi.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<GuestModel> getAllGuests() {
        return guestRepository.findAll();
    }

    public Optional<GuestModel> getGuestById(Long id) {
        return guestRepository.findById(id);
    }

    public List<GuestModel> createGuests(List<GuestModel> guestModels) {
        return guestRepository.saveAll(guestModels);  // Save all guests at once
    }

    public boolean deleteGuest(Long id) {
        if (guestRepository.existsById(id)) {
            guestRepository.deleteById(id);
            return true;
        }
        return false;
    }
}