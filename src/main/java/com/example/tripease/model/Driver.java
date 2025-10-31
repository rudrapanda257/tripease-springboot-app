package com.example.tripease.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    int driverId;
    private String name;
    private int age;
    @Column(unique = true,nullable = false)
    private String emailId;

    @OneToMany(cascade = CascadeType.ALL)  // means you change in parent and it automatically update child , so it can update cab also
    @JoinColumn(name="driver_id")
    List<Booking> bookings = new ArrayList<>();

    // if update cab row Driver table, it automatically it update Cab table.
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cab_id")
    Cab cab;
}
