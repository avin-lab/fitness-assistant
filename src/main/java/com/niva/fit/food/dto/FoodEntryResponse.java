package com.niva.fit.food.dto;

import java.time.Instant;
import java.time.LocalDate;

public record FoodEntryResponse(
        String id,
        LocalDate entryDate,

        String rawText,

        String imageUrl,
        String imageMimeType,
        Long imageSizeBytes,

        Integer estimatedTotalCalories,
        String estimationSource,
        String aiModel,
        Double estimationConfidence,

        Instant createdAt,
        Instant updatedAt
) {}
