package com.example.MCDAHotelApi.wrapper;

import com.example.MCDAHotelApi.model.GuestModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuestListWrapper {
    private List<GuestModel> guests;
}
