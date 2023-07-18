package orderapp.orderapp.Repository;

import orderapp.orderapp.Model.Category;
import orderapp.orderapp.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends MongoRepository<Category,String> {

    List<Category> findAll();
    Optional<Category> findById(String id);
}
