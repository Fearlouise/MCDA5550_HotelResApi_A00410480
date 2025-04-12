package com.example.MCDAHotelApi.wrapper;

import com.example.MCDAHotelApi.model.GuestModel;
import lombok.Data;

import java.util.List;

@Data
public class GuestListWrapper {
    private List<GuestModel> guests;

    public GuestListWrapper() {
    }

    public GuestListWrapper(List<GuestModel> guests) {
        this.guests = guests;
    }
}
