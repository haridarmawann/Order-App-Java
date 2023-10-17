package orderapp.orderapp.Model.reference;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Document("bank")
public class Bank {

}
