package com.example.MCDAHotelApi.controller;

import com.example.MCDAHotelApi.model.GuestModel;
import com.example.MCDAHotelApi.service.GuestService;
import com.example.MCDAHotelApi.wrapper.GuestListWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
public class GuestController {

    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public List<GuestModel> getAllGuests() {
        return guestService.getAllGuests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuestModel> getGuestById(@PathVariable Long id) {
        return guestService.getGuestById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ Updated POST endpoint to accept wrapped guest list
    @PostMapping
    public ResponseEntity<List<GuestModel>> createGuests(@RequestBody GuestListWrapper wrapper) {
        List<GuestModel> guestModels = wrapper.getGuests();

        if (guestModels == null || guestModels.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        List<GuestModel> createdGuests = guestService.createGuests(guestModels);
        return ResponseEntity.status(201).body(createdGuests);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGuest(@PathVariable Long id) {
        boolean isDeleted = guestService.deleteGuest(id);
        return isDeleted
                ? ResponseEntity.ok("Guest deleted successfully")
                : ResponseEntity.notFound().build();
    }
}
