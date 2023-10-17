package orderapp.orderapp.Model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import orderapp.orderapp.Model.reference.EmployeePosition;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
// belum fix
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Document("pejabat")
public class Pejabat {
    @Id
    private String id;
    @Field("nip")
    private String nip;
    @Field("position")
    private EmployeePosition position;
    @Field("sk_file")
    private String skFile;
    @Field("sk_date")
    private String skDate;
    @Field("sk_number")
    private String skNumber;
    @Field("start_date")
    private String startDate;
    @Field("end_date")
    private String endDate;
    @Field("is_structural")
    private boolean isStructural;// structural or tugas tambahan
    @Field("type")
    private String type; // definitif or pelaksana tugas
    @Field("status")
    private String status; // active or non_active
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public EmployeePosition getPosition() {
        return position;
    }

    public void setPosition(EmployeePosition position) {
        this.position = position;
    }

    public String getSkFile() {
        return skFile;
    }

    public void setSkFile(String skFile) {
        this.skFile = skFile;
    }

    public String getSkDate() {
        return skDate;
    }

    public void setSkDate(String skDate) {
        this.skDate = skDate;
    }

    public String getSkNumber() {
        return skNumber;
    }

    public void setSkNumber(String skNumber) {
        this.skNumber = skNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isStructural() {
        return isStructural;
    }

    public void setStructural(boolean structural) {
        isStructural = structural;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
