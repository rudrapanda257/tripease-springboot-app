package com.example.tripease.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor        // default constructor
@AllArgsConstructor     //lombok create all parameter constructor
@Getter
@Setter
@Builder
@Entity
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cab_id")
    private int cabId;
    private String cabNumber;
    private String cabModel;
    private double perKmRate;
    private boolean available;
}
