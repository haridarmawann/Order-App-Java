package orderapp.orderapp.Model.DTO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

public class NewAccountRequest {

    @Id
    private String id;
    @Field("user_id")
    private String userId;
    @Field("name")
    private String name;
    @Field("nip")
    private String nip;
    @Field("nidn")
    private String nidn;
    @Field("email")
    private String email;
    @Field("type")
    private String type;
    @Field("type_name")
    private String typeName;
    @Field("work_unit_id")
    private String workUnitId;
    @Field("work_init")
    private String workInit;
    @Field("work_unit_name")
    private String workUnitName;
    @Field("sk_file")
    private String skFile;
    @Field("sk_number")
    private String skNumber;
    @Field("sk_date")
    private String skDate;
    @Field("startDate")
    private String startDate;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getWorkUnitId() {
        return workUnitId;
    }

    public void setWorkUnitId(String workUnitId) {
        this.workUnitId = workUnitId;
    }

    public String getWorkInit() {
        return workInit;
    }

    public void setWorkInit(String workInit) {
        this.workInit = workInit;
    }

    public String getWorkUnitName() {
        return workUnitName;
    }

    public void setWorkUnitName(String workUnitName) {
        this.workUnitName = workUnitName;
    }

    public String getSkFile() {
        return skFile;
    }

    public void setSkFile(String skFile) {
        this.skFile = skFile;
    }

    public String getSkNumber() {
        return skNumber;
    }

    public void setSkNumber(String skNumber) {
        this.skNumber = skNumber;
    }

    public String getSkDate() {
        return skDate;
    }

    public void setSkDate(String skDate) {
        this.skDate = skDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
