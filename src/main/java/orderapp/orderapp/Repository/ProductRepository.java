package orderapp.orderapp.Repository;

import orderapp.orderapp.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findAll();
    Optional<Product> findById(String id);
    Optional<Product> findByCategoryId(String CategoryI);
}
