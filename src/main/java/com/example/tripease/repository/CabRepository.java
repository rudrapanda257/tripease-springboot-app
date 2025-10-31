package com.example.tripease.repository;

import com.example.tripease.model.Cab;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CabRepository extends JpaRepository<Cab,Integer> {
    @Query(value = "SELECT * FROM cab WHERE available = true ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Cab getAvailableCarRandom();
}
