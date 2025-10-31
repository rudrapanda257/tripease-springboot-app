package com.example.tripease.dto.response;

import lombok.*;

@NoArgsConstructor        // default constructor
@AllArgsConstructor     //lombok create all parameter constructor
@Getter
@Setter
@Builder
public class CabResponse {
    private String carNumber;
    private String cabModel;
    private double perKmRate;
    private boolean available;

    private DriverResponse driver;
}
