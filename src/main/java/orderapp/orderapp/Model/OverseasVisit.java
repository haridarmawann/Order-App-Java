package orderapp.orderapp.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Document("overseas_visit")
public class OverseasVisit {
    private String id;
    @Field("user_id")
    private String userId;
    @Field("destination")
    private String destination;
    @Field("period")
    private String period;
    @Field("resource_cost")
    private String resourceCost;
    @Field("sk_number")
    private String SkNumber;
    @Field("sk_date")
    private LocalDate SkDate;
    @Field("sk_file")
    private String SkFile;
    @Field("created_at")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @Field("updated_at")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
    @Field("created_by")
    private String createdBy;
    @Field("updated_by")
    private String updatedBy;
    @Field("is_deleted")
    private Boolean isDeleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getResourceCost() {
        return resourceCost;
    }

    public void setResourceCost(String resourceCost) {
        this.resourceCost = resourceCost;
    }

    public String getSkNumber() {
        return SkNumber;
    }

    public void setSkNumber(String skNumber) {
        SkNumber = skNumber;
    }

    public LocalDate getSkDate() {
        return SkDate;
    }

    public void setSkDate(LocalDate skDate) {
        SkDate = skDate;
    }

    public String getSkFile() {
        return SkFile;
    }

    public void setSkFile(String skFile) {
        SkFile = skFile;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
