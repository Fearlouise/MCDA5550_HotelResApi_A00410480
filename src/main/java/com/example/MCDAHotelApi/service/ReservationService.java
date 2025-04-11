package com.example.MCDAHotelApi.service;

import com.example.MCDAHotelApi.model.ReservationModel;
import com.example.MCDAHotelApi.model.HotelModel;
import com.example.MCDAHotelApi.model.CustomerModel;
import com.example.MCDAHotelApi.repository.ReservationRepository;
import com.example.MCDAHotelApi.repository.HotelRepository;
import com.example.MCDAHotelApi.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final HotelRepository hotelRepository;
    private final CustomerRepository customerRepository;

    // Constructor to inject dependencies for Reservation, Hotel, and Customer repositories
    public ReservationService(ReservationRepository reservationRepository,
                              HotelRepository hotelRepository,
                              CustomerRepository customerRepository) {
        this.reservationRepository = reservationRepository;
        this.hotelRepository = hotelRepository;
        this.customerRepository = customerRepository;
    }

    // Method to get all reservations
    public List<ReservationModel> getAllReservations() {
        return reservationRepository.findAll();
    }

    // Method to get a reservation by its ID
    public Optional<ReservationModel> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    // Method to create a new reservation
    public ReservationModel createReservation(ReservationModel reservationModel) {
        // Fetch the hotel and customer using their respective IDs
        HotelModel hotel = hotelRepository.findById(reservationModel.getHotel().getId())
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        CustomerModel customer = customerRepository.findById(reservationModel.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // Set the hotel and customer to the reservation
        reservationModel.setHotel(hotel);
        reservationModel.setCustomer(customer);

        // Save and return the reservation
        return reservationRepository.save(reservationModel);
    }

    // Method to delete a reservation by its ID
    public boolean deleteReservation(Long id) {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
