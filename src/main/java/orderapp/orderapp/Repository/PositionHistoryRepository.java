package orderapp.orderapp.Repository;

import orderapp.orderapp.Model.PositionHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PositionHistoryRepository extends MongoRepository<PositionHistory,String> {
}
