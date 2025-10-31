package com.example.tripease.dto.request;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@NoArgsConstructor        // default constructor
@AllArgsConstructor     //lombok create all parameter constructor
@Getter
@Setter
public class BookingRequest {
    private String pickup;
    private String destination;
    private double tripDistanceInKm;
}
