//package orderapp.orderapp.Model;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.databind.PropertyNamingStrategies;
//import com.fasterxml.jackson.databind.annotation.JsonNaming;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.Field;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//// anjing gatau namanya
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
//@Document("activity_student_role")
//public class CommunityServiceStudent {
//    @Id
//    private String id;
//    @Field("user_id")
//    private String userId;
//    @Field("activity_name")
//    private String ActivityName;
//    @Field("place")
//    private String place;
//    @Field("position")
//    private String position;
//    @Field("activity_level")
//    private String activityLevel;
//    @Field("note")
//    private String note;
//    @Field("start_date")
//    private LocalDate startDate;
//    @Field("end_date")
//    private LocalDate endDate;
//    @Field("sk_file")
//    private String skFile;
//    @Field("created_at")
//    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime createdAt;
//    @Field("updated_at")
//    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime updatedAt;
//    @Field("created_by")
//    private String createdBy;
//    @Field("updated_by")
//    private String updatedBy;
//    @Field("is_deleted")
//    private Boolean isDeleted;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public String getActivityName() {
//        return ActivityName;
//    }
//
//    public void setActivityName(String activityName) {
//        ActivityName = activityName;
//    }
//
//    public String getPlace() {
//        return place;
//    }
//
//    public void setPlace(String place) {
//        this.place = place;
//    }
//
//    public String getPosition() {
//        return position;
//    }
//
//    public void setPosition(String position) {
//        this.position = position;
//    }
//
//    public String getActivityLevel() {
//        return activityLevel;
//    }
//
//    public void setActivityLevel(String activityLevel) {
//        this.activityLevel = activityLevel;
//    }
//
//    public String getNote() {
//        return note;
//    }
//
//    public void setNote(String note) {
//        this.note = note;
//    }
//
//    public LocalDate getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(LocalDate startDate) {
//        this.startDate = startDate;
//    }
//
//    public LocalDate getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(LocalDate endDate) {
//        this.endDate = endDate;
//    }
//
//    public String getSkFile() {
//        return skFile;
//    }
//
//    public void setSkFile(String skFile) {
//        this.skFile = skFile;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public LocalDateTime getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(LocalDateTime updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//
//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public String getUpdatedBy() {
//        return updatedBy;
//    }
//
//    public void setUpdatedBy(String updatedBy) {
//        this.updatedBy = updatedBy;
//    }
//
//    public Boolean getDeleted() {
//        return isDeleted;
//    }
//
//    public void setDeleted(Boolean deleted) {
//        isDeleted = deleted;
//    }
//}
