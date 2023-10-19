package orderapp.orderapp.Repository;

import orderapp.orderapp.Model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee,String> {

    List<Employee> findAllEmployeeByIsDeleted(Boolean isDeleted);
}
