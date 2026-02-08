package com.niva.fit.food;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface FoodEntryRepository extends MongoRepository<FoodEntry, String> {

    // Query generated automatically by Spring Data from the method name
    List<FoodEntry> findByUserIdAndEntryDateBetween(String userId, LocalDate from, LocalDate to);
}
