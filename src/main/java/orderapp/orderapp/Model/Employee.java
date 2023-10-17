package orderapp.orderapp.Model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import orderapp.orderapp.Model.DTO.Address;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Document("employee")
public class Employee {
    private String id;
    @Field("sister_uuid")
    private String sisterUuid;
    @Field("front_degree")
    private String frontDegree;
    private String name;
    @Field("behind_degree")
    private String behindDegree;
    private String gender;
    private String nip;
    private String nidn; // nomor induk dosen nasional
    private String email;
    @Field("email_usu")
    private String emailUSU;
    private String photo;
    private List<Address> addresses;
    private String npwp;

    private String status; // aktif,pensiun, meninggal,tugas belajar,izin belajar,berhenti, dipecat

    @Field("is_deleted")
    private boolean isDeleted;

    //esc


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getSisterUuid() {
        return sisterUuid;
    }

    public void setSisterUuid(String sisterUuid) {
        this.sisterUuid = sisterUuid;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
