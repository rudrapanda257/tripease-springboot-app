package com.example.tripease.model;


import com.example.tripease.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor        // default constructor
@AllArgsConstructor     //lombok create all parameter constructor
@Getter
@Setter
@Entity
@Builder
@NonNull
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String name;
    private int age;
    @Column(unique = true, nullable = false)
    private String emailId;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String address;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="Customer_Id")
    private List<Booking> bookings = new ArrayList<>();

}
