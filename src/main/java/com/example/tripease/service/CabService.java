package com.example.tripease.service;

import com.example.tripease.dto.request.CabRequest;
import com.example.tripease.dto.response.CabResponse;
import com.example.tripease.model.Cab;
import com.example.tripease.model.Driver;
import com.example.tripease.repository.DriverRepository;
import com.example.tripease.transformer.CabTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CabService {
    @Autowired
    DriverRepository driverRepository;

    public CabResponse registerCab(CabRequest cabRequest, int driverid) {
        Driver driver = driverRepository.findById(driverid).orElse(null);
        if(driver != null){   // check driver exist or not
            Cab cab = CabTransformer.cabRequestToCab(cabRequest); // update cabRequest to Cab Entity
            driver.setCab(cab);  // set the cab Entity inside Driver Entity

            Driver saveDriver = driverRepository.save(driver); // save both driver and cab     ||  update thr Driver table by Driver entity
            return CabTransformer.cabToCabResponse(saveDriver.getCab(), saveDriver);
        }
        return null;
    }
}
