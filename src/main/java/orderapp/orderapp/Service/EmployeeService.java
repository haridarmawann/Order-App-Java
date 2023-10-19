package orderapp.orderapp.Service;

import orderapp.orderapp.Model.DTO.NewAccountRequest;
import orderapp.orderapp.Model.Employee;
import orderapp.orderapp.Model.Mutation;
import orderapp.orderapp.Repository.EmployeeRepository;
import orderapp.orderapp.Repository.MutationRepository;
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
    private EmployeeRepository employeeRepository;

    @Autowired
    private MutationRepository mutationRepository;

    AppHelper helper = new AppHelper();

    // TODO: 19/10/2023 send password to email user
    // TODO: 19/10/2023 created filter user simsdm
    // 

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }
    public Optional<Employee> getEmployeeById(String id){
        return employeeRepository.findById(id);
    }
    public Employee getFilterEmployee(HashMap<String, Object> request){
        return null;
    }

    public Employee createNewUser(NewAccountRequest request) {
        LocalDateTime now = new AppHelper().getCurrentTime();
        Employee employee = createEmployeeFromRequest(request,now);
        Mutation mutation = createFirstJob(employee.getUserId(), request,now);
        mutationRepository.save(mutation);
        return employeeRepository.save(employee);
    }

    public Employee createEmployeeFromRequest(NewAccountRequest request,LocalDateTime now) {
        Employee employee = new Employee();
        employee.mapFromRequest(request);


        employee.setCreatedAt(now);
        employee.setUpdatedAt(now);
        return employee;
    }

    public Mutation createFirstJob(String userId, NewAccountRequest request,LocalDateTime now) {
        LocalDate startDate = LocalDate.parse(request.getStartDate());
        LocalDate skDate = LocalDate.parse(request.getSkDate());
        Mutation mutation = new Mutation();
        mutation.setUserId(userId);
        mutation.setUnitName(request.getWorkUnitName());
        mutation.setStartDate(startDate);
        mutation.setSkDate(skDate);
        mutation.setSkFile(request.getSkFile());
        mutation.setFirst(true);
        mutation.setDeleted(false);
        mutation.setCreatedAt(now);
        mutation.setUpdatedAt(now);
        return mutation;
    }
    


}

