package orderapp.orderapp.Service;

import orderapp.orderapp.Model.DTO.NewAccountRequest;
import orderapp.orderapp.Model.Employee;
import orderapp.orderapp.Model.MutationHistory;
import orderapp.orderapp.Repository.EmployeeRepository;
import orderapp.orderapp.tools.AppHelper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }
    public Optional<Employee> getEmployeeById(String id){
        return employeeRepository.findById(id);
    }

    public Employee getFilterEmployee(HashMap<String, Object> request){
        return null;
    }

    public Employee createNewUser(NewAccountRequest request){

        Employee employee = new Employee();
        employee.mapFromRequest(request);
        LocalDateTime now = new AppHelper().getCurrentTime();
        employee.setCreatedAt(now);
        employee.setUpdatedAt(now);

        MutationHistory mutation = new MutationHistory();
        mutation.setUserId(employee.getUserId());
        mutation.setUnitName(request.getWorkUnitName());
        LocalDate startDate = LocalDate.parse(request.getStartDate());
        LocalDate skDate = LocalDate.parse(request.getSkDate());
        mutation.setStartDate(startDate);
        mutation.setSkDate(skDate);
        mutation.setSkFile(request.getSkFile());
        mutation.setFirst(true);
        mutation.setDeleted(false);
//        mutationRepository.save(mutation);







        return employeeRepository.save(employee);

    }


}
