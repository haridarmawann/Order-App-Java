package orderapp.orderapp.Model.reference;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;


// untuk unit belum bisa dipastikan modelnya.
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Document("unit")
public class Unit {

    @Id
    private String id;
    @Field("parent_id")
    private String parentId;
    @Field("nim_label")
    private String nimLabel;
    private String level;
    private String type;
    @Field("unit_name")
    private String unitName;
    @Field("address")
    private String address;
    @Field("founded_date")
    private String foundedDate;
    @Field("sk_number")
    private String skNumber;
    @Field("sk_date")
    private LocalDate skDate;
    @Field("sk_file")
    private String skFile;
    @Field("status")
    private String status;
    @Field("created_at")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private String createdAt;
    @Field("updated_at")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private String updatedAt;
    @Field("created_by")
    private String createdBy;
    @Field("updated_by")
    private String updatedBy;
    @Field("is_deleted")
    private boolean isDeleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getNimLabel() {
        return nimLabel;
    }

    public void setNimLabel(String nimLabel) {
        this.nimLabel = nimLabel;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFoundedDate() {
        return foundedDate;
    }

    public void setFoundedDate(String foundedDate) {
        this.foundedDate = foundedDate;
    }

    public String getSkNumber() {
        return skNumber;
    }

    public void setSkNumber(String skNumber) {
        this.skNumber = skNumber;
    }

    public LocalDate getSkDate() {
        return skDate;
    }

    public void setSkDate(LocalDate skDate) {
        this.skDate = skDate;
    }

    public String getSkFile() {
        return skFile;
    }

    public void setSkFile(String skFile) {
        this.skFile = skFile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
