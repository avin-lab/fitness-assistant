package com.niva.fit.food;

import com.niva.fit.food.dto.CreateFoodEntryRequest;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Service
public class FoodEntryService {

    private final FoodEntryRepository repo;

    public FoodEntryService(FoodEntryRepository repo) {
        this.repo = repo;
    }

    public FoodEntry create(String userId, CreateFoodEntryRequest req) {
        FoodEntry e = new FoodEntry();
        e.setUserId(userId);
        e.setEntryDate(req.entryDate());
        e.setRawText(req.rawText());

        // Image reference fields (optional for now)
        e.setImageUrl(req.imageUrl());
        e.setImageMimeType(req.imageMimeType());
        e.setImageSizeBytes(req.imageSizeBytes());

        // Calories (optional for now; later AI fills this)
        e.setEstimatedTotalCalories(req.estimatedTotalCalories());

        // Simple source logic (text vs image vs both)
        boolean hasText = req.rawText() != null && !req.rawText().isBlank();
        boolean hasImage = req.imageUrl() != null && !req.imageUrl().isBlank();
        if (hasText && hasImage) e.setEstimationSource("TEXT+IMAGE");
        else if (hasImage) e.setEstimationSource("IMAGE");
        else e.setEstimationSource("TEXT");

        // AI metadata (will be set later by AI service)
        e.setAiModel(null);
        e.setEstimationConfidence(null);

        Instant now = Instant.now();
        e.setCreatedAt(now);
        e.setUpdatedAt(now);

        return repo.save(e);
    }

    public List<FoodEntry> list(String userId, LocalDate from, LocalDate to) {
        return repo.findByUserIdAndEntryDateBetween(userId, from, to);
    }
}
