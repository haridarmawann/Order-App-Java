package orderapp.orderapp.Repository;

import orderapp.orderapp.Model.OverseasVisit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OverseasVisitRepository extends MongoRepository<OverseasVisit,String> {
}
