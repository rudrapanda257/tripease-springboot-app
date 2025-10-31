package com.example.tripease.service;

import com.example.tripease.dto.request.BookingRequest;
import com.example.tripease.dto.response.BookingResponse;
import com.example.tripease.model.Booking;
import com.example.tripease.model.Cab;
import com.example.tripease.model.Customer;
import com.example.tripease.model.Driver;
import com.example.tripease.repository.BookingRepository;
import com.example.tripease.repository.CabRepository;
import com.example.tripease.repository.CustomerRepository;
import com.example.tripease.repository.DriverRepository;
import com.example.tripease.transformer.BookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CabRepository cabRepository;
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    CustomerRepository customerRepository;


    public BookingResponse addBooking(BookingRequest bookingRequest, int customerid) {
        Customer customer = customerRepository.findById(customerid).orElse(null);
        if(customer != null){
            Cab avalableCab = cabRepository.getAvailableCarRandom();
            if(avalableCab != null){
                Booking booking = BookingTransformer.bookingRequestToBooking(bookingRequest, avalableCab.getPerKmRate());
                Booking saveBooking = (Booking) bookingRepository.save(booking);

                avalableCab.setAvailable(false);
                customer.getBookings().add(saveBooking);

                Driver driver = driverRepository.findDriverByCabId(avalableCab.getCabId());
                driver.getBookings().add(booking);

                Customer saveCustomer = customerRepository.save(customer);
                Driver saveDriver = driverRepository.save(driver);

                return BookingTransformer.bookingToBookingResponse(saveBooking, saveCustomer, avalableCab, saveDriver );
            }


        }
        return null;

    }
}
