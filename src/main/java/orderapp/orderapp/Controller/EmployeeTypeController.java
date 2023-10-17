package orderapp.orderapp.Controller;

import orderapp.orderapp.Helper.ResponseWriter;
import orderapp.orderapp.Model.DTO.ResponseBody;
import orderapp.orderapp.Model.reference.EmployeeType;
import orderapp.orderapp.Service.EmployeeTypeService;
import orderapp.orderapp.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class EmployeeTypeController {

    @Autowired
    EmployeeTypeService employeeTypeService;

    @PostMapping("/employee-type")
    public ResponseEntity<ResponseBody> addEmployeeType(@RequestBody EmployeeType employeeType) {
        try {
            return ResponseWriter.created("Berhasil menambahkan data", employeeTypeService.createEmployeeType(employeeType));
        } catch (NotFoundException e) {
            return ResponseWriter.invalid(e.getMessage(), null);
        } catch (Exception e) {
            return ResponseWriter.fail("gagal menambahkan data", e.getMessage());
        }
    }

    @GetMapping("/employee-type")
    public ResponseEntity<ResponseBody> getEmployeeType(){
        try{
            return ResponseWriter.created("Berhasil menambahkan data",employeeTypeService.getEmployeeType());
        } catch (Exception e){
            return ResponseWriter.fail("gagal mendapatkan data", e.getMessage());
        }
    }
    @GetMapping("/employee-type/{id}")
    public ResponseEntity<ResponseBody> getEmployeeTypeById(@PathVariable String id){
        try{
            return ResponseWriter.created("Berhasil menambahkan data",employeeTypeService.findTypeById(id));
        } catch (Exception e){
            return ResponseWriter.fail("gagal mendapatkan data", e.getMessage());
        }
    }

    @PutMapping("/employee-type/{id}")
    public ResponseEntity<ResponseBody> updateEmployeeType(@PathVariable String id,@RequestBody EmployeeType employeeType){
        try {
            return ResponseWriter.created("Berhasil Merubah Data",employeeTypeService.updateEmployeeType(id,employeeType));
        } catch (NotFoundException e){
            return ResponseWriter.write(404, true, e.getMessage(), null);
        } catch (IllegalArgumentException e){
            return ResponseWriter.invalid(e.getMessage(), null);
        } catch (Exception e){
            return ResponseWriter.fail("gagal mengubah data", e.getMessage());
        }
    }

    @DeleteMapping("/employee-type/{id}")
    public ResponseEntity<ResponseBody> deleteEmployeeType(@PathVariable String id) {
        try {
            employeeTypeService.deleteEmployeeType(id);
            return ResponseWriter.created("Berhasil menghapus data", null);
        } catch (NotFoundException e) {
            return ResponseWriter.empty( null);
        } catch (IllegalArgumentException e) {
            return ResponseWriter.invalid(e.getMessage(), null);
        } catch (Exception e) {
            return ResponseWriter.write(500, true, "Gagal Menghapus data: "+e.getMessage(), null);
        }
    }

}

