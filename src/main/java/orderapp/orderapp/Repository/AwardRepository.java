package orderapp.orderapp.Repository;

import orderapp.orderapp.Model.Award;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AwardRepository extends MongoRepository<Award,String> {
}
