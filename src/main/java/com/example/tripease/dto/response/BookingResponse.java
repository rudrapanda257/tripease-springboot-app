package com.example.tripease.dto.response;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@NoArgsConstructor        // default constructor
@AllArgsConstructor     //lombok create all parameter constructor
@Getter
@Setter
@NonNull
@Builder
public class BookingResponse {
    private String pickup;
    private String destination;
    private double tripDistanceInKm;
    private double billAmount;

    Date bookedAt;
    Date lastUpadateAt;

    CustomerResponse customer;
    CabResponse cab;
}
