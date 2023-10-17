package orderapp.orderapp.Repository;

import orderapp.orderapp.Model.reference.EmployeeType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeTypeRepository extends MongoRepository<EmployeeType,String> {

    List<EmployeeType> findAllEmployeeTypeByIsDeletedFalse();
    Optional<EmployeeType> findEmployeeTypeBySlug(String slug);

}
