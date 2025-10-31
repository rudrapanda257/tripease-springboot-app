package com.example.tripease.dto.response;

import lombok.*;

@NoArgsConstructor        // default constructor
@AllArgsConstructor     //lombok create all parameter constructor
@Getter
@Setter
@Builder
public class CustomerResponse {
    private String name;
    private int age;
    private String emailId;

}
