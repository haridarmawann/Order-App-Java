package orderapp.orderapp.Repository;

import orderapp.orderapp.Model.Information;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InformationRepository extends MongoRepository<Information,String> {
}
