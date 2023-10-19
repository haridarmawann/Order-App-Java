package orderapp.orderapp.Controller;

import orderapp.orderapp.Model.DTO.NewAccountRequest;
import orderapp.orderapp.Model.DTO.ResponseBody;
import orderapp.orderapp.Service.EmployeeService;
import orderapp.orderapp.exception.NotFoundException;
import orderapp.orderapp.tools.ResponseWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create-new-employee")
    public ResponseEntity<ResponseBody> createNewUser(@RequestBody NewAccountRequest newAccountRequest) {
        try {
            return ResponseWriter.created("Berhasil menambahkan data", employeeService.createNewUser(newAccountRequest));
        } catch (NotFoundException e) {
            return ResponseWriter.invalid(e.getMessage(), null);
        } catch (Exception e) {
            return ResponseWriter.fail("gagal menambahkan data", e.getMessage());
        }
    }

    @GetMapping("/list-employee")
    public ResponseEntity<ResponseBody> getEmployeeType(){
        try{
            return ResponseWriter.created("Berhasil menambahkan data",employeeService.getAllEmployee());
        } catch (Exception e){
            return ResponseWriter.fail("gagal mendapatkan data", e.getMessage());
        }
    }




}
