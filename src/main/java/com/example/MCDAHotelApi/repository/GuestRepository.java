package com.example.MCDAHotelApi.repository;

import com.example.MCDAHotelApi.model.GuestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<GuestModel, Long> {
}