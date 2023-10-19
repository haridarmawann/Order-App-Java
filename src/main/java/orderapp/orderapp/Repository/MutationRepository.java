package orderapp.orderapp.Repository;

import orderapp.orderapp.Model.Mutation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MutationRepository extends MongoRepository<Mutation,String> {
}
