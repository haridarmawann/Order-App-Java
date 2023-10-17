package orderapp.orderapp.Repository;

import orderapp.orderapp.Model.CourseHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseHistoryRepository extends MongoRepository<CourseHistory,String> {
}
