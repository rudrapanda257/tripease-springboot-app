package com.example.tripease.transformer;

import com.example.tripease.dto.request.DriverRequest;
import com.example.tripease.dto.response.DriverResponse;
import com.example.tripease.model.Driver;

public class DriverTransformer {

    public  static Driver driverRequestToDriver(DriverRequest driverRequest){
         Driver driver = Driver.builder().name(driverRequest.getName())
                 .age(driverRequest.getAge())
                 .emailId(driverRequest.getEmailId()).build();
         return driver;
    }

    public static DriverResponse driverToDriverResponse(Driver savedriver) {
        DriverResponse driverResponse = DriverResponse.builder().name(savedriver.getName())
                .age(savedriver.getAge())
                .emailId(savedriver.getEmailId()).build();
        return driverResponse;
    }
}
