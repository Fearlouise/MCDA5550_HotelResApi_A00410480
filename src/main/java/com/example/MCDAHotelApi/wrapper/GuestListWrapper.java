package com.example.MCDAHotelApi.wrapper;

import com.example.MCDAHotelApi.model.GuestModel;
import java.util.List;

public class GuestListWrapper {
    private List<GuestModel> guests;

    public GuestListWrapper() {
    }

    public GuestListWrapper(List<GuestModel> guests) {
        this.guests = guests;
    }

    public List<GuestModel> getGuests() {
        return guests;
    }

    public void setGuests(List<GuestModel> guests) {
        this.guests = guests;
    }
}
