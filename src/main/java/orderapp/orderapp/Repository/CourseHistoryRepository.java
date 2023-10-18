package orderapp.orderapp.Repository;

import orderapp.orderapp.Model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseHistoryRepository extends MongoRepository<Course,String> {
}
