package orderapp.orderapp.Model.reference;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


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
    private String skDate;
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
}
