package com.niva.fit.food.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CreateFoodEntryRequest(
        @NotNull LocalDate entryDate,

        @Size(max = 4000) String rawText,

        // For now, imageUrl is optional. Later it will come from an upload endpoint.
        @Size(max = 2000) String imageUrl,

        @Size(max = 100) String imageMimeType,
        @Min(0) Long imageSizeBytes,

        @Min(0) Integer estimatedTotalCalories
) {}
