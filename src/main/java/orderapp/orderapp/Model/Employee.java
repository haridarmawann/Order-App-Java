package orderapp.orderapp.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import orderapp.orderapp.Model.DTO.Address;
import orderapp.orderapp.Model.DTO.PhysicalDescription;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Document("employee")
public class Employee {
    @Id
    private String id;
    @Field("user_id")
    private String userId; // userId simsdm lama
    @Field("sister_uuid")
    private String sisterUuid;
    @Field("front_degree")
    private String frontDegree;
    @Field("name")
    private String name;
    @Field("behind_degree")
    private String behindDegree;
    @Field("gender")
    private String gender;
    @Field("nip")
    private String nip;
    @Field("nidn")
    private String nidn; // nomor induk dosen nasional
    @Field("email")
    private String email;
    @Field("email_usu")
    private String emailUSU;
    @Field("photo")
    private String photo;
    @Field("address")
    private Address address;
    @Field("religion")
    private String religion;
    @Field("phone")
    private String phone;
    @Field("marital_status")
    private String maritalStatus;
    @Field("physical_description")
    private PhysicalDescription physicalDescription;
    @Field("npwp")
    private String npwp;
    @Field("birth_date")
    private LocalDate BirthDate;
    @Field("birth_place")
    private String birthPlace;
    @Field("birth_file")
    private String birthFile;
    @Field("status")
    private String status; // aktif,pensiun, meninggal,tugas belajar,izin belajar,berhenti, dipecat
    @Field("type")
    private String type; // jenis kepegawaian
    @Field("type_name")
    private String typeName; // nama jenis kepegawaian
    @Field("password")
    private String password;
    @Field("reset_password_key")
    private String resetPasswordKey;
    @Field("work_unit_id")
    private String workUnitId;
    @Field("work_unit_init")
    private String workUnitInit;
    @Field("work_unit_name")
    private String workUnitName;
    @Field("study_program_id")
    private String studyProgramId;
    @Field("study_program")
    private String studyProgram;
    @Field("is_deleted")
    private Boolean isDeleted;
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

    public String getSisterUuid() {
        return sisterUuid;
    }

    public void setSisterUuid(String sisterUuid) {
        this.sisterUuid = sisterUuid;
    }

    public String getFrontDegree() {
        return frontDegree;
    }

    public void setFrontDegree(String frontDegree) {
        this.frontDegree = frontDegree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBehindDegree() {
        return behindDegree;
    }

    public void setBehindDegree(String behindDegree) {
        this.behindDegree = behindDegree;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNidn() {
        return nidn;
    }

    public void setNidn(String nidn) {
        this.nidn = nidn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailUSU() {
        return emailUSU;
    }

    public void setEmailUSU(String emailUSU) {
        this.emailUSU = emailUSU;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public PhysicalDescription getPhysicalDescription() {
        return physicalDescription;
    }

    public void setPhysicalDescription(PhysicalDescription physicalDescription) {
        this.physicalDescription = physicalDescription;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        BirthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getBirthFile() {
        return birthFile;
    }

    public void setBirthFile(String birthFile) {
        this.birthFile = birthFile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResetPasswordKey() {
        return resetPasswordKey;
    }

    public void setResetPasswordKey(String resetPasswordKey) {
        this.resetPasswordKey = resetPasswordKey;
    }

    public String getWorkUnitId() {
        return workUnitId;
    }

    public void setWorkUnitId(String workUnitId) {
        this.workUnitId = workUnitId;
    }

    public String getWorkUnitInit() {
        return workUnitInit;
    }

    public void setWorkUnitInit(String workUnitInit) {
        this.workUnitInit = workUnitInit;
    }

    public String getWorkUnitName() {
        return workUnitName;
    }

    public void setWorkUnitName(String workUnitName) {
        this.workUnitName = workUnitName;
    }

    public String getStudyProgramId() {
        return studyProgramId;
    }

    public void setStudyProgramId(String studyProgramId) {
        this.studyProgramId = studyProgramId;
    }

    public String getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(String studyProgram) {
        this.studyProgram = studyProgram;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
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
}
