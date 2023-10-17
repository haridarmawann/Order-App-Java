package orderapp.orderapp.Repository;

import orderapp.orderapp.Model.Family;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FamilyRepository extends MongoRepository<Family,String> {
}
