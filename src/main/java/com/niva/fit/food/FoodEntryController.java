package com.niva.fit.food;

import com.niva.fit.food.dto.CreateFoodEntryRequest;
import com.niva.fit.food.dto.FoodEntryResponse;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/food-entries")
public class FoodEntryController {

    private final FoodEntryService service;

    public FoodEntryController(FoodEntryService service) {
        this.service = service;
    }

    // Temporary: user scoping via header. Later: JWT.
    private String userIdOrDefault(String header) {
        return (header == null || header.isBlank()) ? "local" : header.trim();
    }

    @PostMapping
    public FoodEntryResponse create(
            @RequestHeader(value = "X-User-Id", required = false) String userHeader,
            @Valid @RequestBody CreateFoodEntryRequest req
    ) {
        String userId = userIdOrDefault(userHeader);
        FoodEntry saved = service.create(userId, req);
        return toResponse(saved);
    }

    @GetMapping
    public List<FoodEntryResponse> list(
            @RequestHeader(value = "X-User-Id", required = false) String userHeader,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to
    ) {
        String userId = userIdOrDefault(userHeader);
        return service.list(userId, from, to).stream().map(this::toResponse).toList();
    }

    private FoodEntryResponse toResponse(FoodEntry e) {
        return new FoodEntryResponse(
                e.getId(),
                e.getEntryDate(),
                e.getRawText(),

                e.getImageUrl(),
                e.getImageMimeType(),
                e.getImageSizeBytes(),

                e.getEstimatedTotalCalories(),
                e.getEstimationSource(),
                e.getAiModel(),
                e.getEstimationConfidence(),

                e.getCreatedAt(),
                e.getUpdatedAt()
        );
    }
}
