package orderapp.orderapp.Model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Document("information")
public class Information {
    private String id;
    private String type;
    private String note;
    @Field("sk_file")
    private String SkFile;
    @Field("sk_number")
    private String SkNumber;
    @Field("sk_date")
    private LocalDate SkDate;
}
