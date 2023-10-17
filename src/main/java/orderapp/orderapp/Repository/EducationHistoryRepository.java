package orderapp.orderapp.Repository;

import orderapp.orderapp.Model.EducationHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EducationHistoryRepository extends MongoRepository<EducationHistory,String> {
}
