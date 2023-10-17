package orderapp.orderapp.Model.reference;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Document("degree")
public class Degree {

    @Field("id")
    private String id;
    @Field("name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Degree{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
