package com.niva.fit.food;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDate;

@Document(collection = "food_entries")
public class FoodEntry {
    @Id
    private String id;

    private String userId;
    private LocalDate entryDate;

    private String rawText;
    private Integer estimatedTotalCalories;

    private Instant createdAt;
    private Instant updatedAt;

    private String imageUrl;       // e.g., https://... or s3://...
    private String imageMimeType;  // e.g., image/jpeg
    private Long imageSizeBytes;   // e.g., 183245

    private String estimationSource;      // "TEXT" | "IMAGE" | "TEXT+IMAGE"
    private String aiModel;               // e.g., "gpt-4o-mini"
    private Double estimationConfidence;  // 0.0 - 1.0


    public FoodEntry() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public LocalDate getEntryDate() { return entryDate; }
    public void setEntryDate(LocalDate entryDate) { this.entryDate = entryDate; }

    public String getRawText() { return rawText; }
    public void setRawText(String rawText) { this.rawText = rawText; }

    public Integer getEstimatedTotalCalories() { return estimatedTotalCalories; }
    public void setEstimatedTotalCalories(Integer estimatedTotalCalories) { this.estimatedTotalCalories = estimatedTotalCalories; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getImageMimeType() { return imageMimeType; }
    public void setImageMimeType(String imageMimeType) { this.imageMimeType = imageMimeType; }

    public Long getImageSizeBytes() { return imageSizeBytes; }
    public void setImageSizeBytes(Long imageSizeBytes) { this.imageSizeBytes = imageSizeBytes; }

    public String getEstimationSource() { return estimationSource; }
    public void setEstimationSource(String estimationSource) { this.estimationSource = estimationSource; }

    public String getAiModel() { return aiModel; }
    public void setAiModel(String aiModel) { this.aiModel = aiModel; }

    public Double getEstimationConfidence() { return estimationConfidence; }
    public void setEstimationConfidence(Double estimationConfidence) { this.estimationConfidence = estimationConfidence; }

}
