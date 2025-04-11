package com.example.MCDAHotelApi.repository;

import com.example.MCDAHotelApi.model.HotelModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<HotelModel, Long> {
}

