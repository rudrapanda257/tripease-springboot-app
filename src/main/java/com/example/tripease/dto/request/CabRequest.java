package com.example.tripease.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor        // default constructor
@AllArgsConstructor     //lombok create all parameter constructor
@Getter
@Setter
public class CabRequest {

    private String carNumber;
    private String cabModel;
    private double perKmRate;

}
