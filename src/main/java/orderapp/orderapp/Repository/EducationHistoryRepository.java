package orderapp.orderapp.Repository;

import orderapp.orderapp.Model.Education;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EducationHistoryRepository extends MongoRepository<Education,String> {
}
