package orderapp.orderapp.Service;

import orderapp.orderapp.Model.reference.EmployeeType;
import orderapp.orderapp.Repository.EmployeeTypeRepository;
import orderapp.orderapp.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {
    @Autowired
    EmployeeTypeRepository employeeTypeRepository;

    public void insertSeeder(EmployeeType employeeType){
        Optional<EmployeeType> _employeeType = employeeTypeRepository.findEmployeeTypeBySlug(employeeType.getSlug());

        if (_employeeType.isEmpty()) {
            employeeTypeRepository.save(employeeType);
        }
    }

    public EmployeeType createEmployeeType(EmployeeType employeeType){
        EmployeeType type = new EmployeeType();

        type.setTitle(employeeType.getTitle());
        type.setSlug(employeeType.getSlug());
        type.setCreatedAt(LocalDateTime.now());
        type.setUpdatedAt(LocalDateTime.now());
        return employeeTypeRepository.save(type);
    }

    public List<EmployeeType> getEmployeeType(){
        return employeeTypeRepository.findAllEmployeeTypeByIsDeletedFalse();
    }

    public EmployeeType updateEmployeeType(String id,EmployeeType employeeType){
        Optional<EmployeeType> dataType = employeeTypeRepository.findById(id);
        if (dataType.isEmpty()){
            throw new NotFoundException("jenis pegawai tidak ditemukan");
        } else {
            EmployeeType data = dataType.get();
            data.setTitle(employeeType.getTitle());
            data.setUpdatedAt(LocalDateTime.now());
            return employeeTypeRepository.save(data);
        }
    }

    public EmployeeType findTypeById(String id){
        Optional<EmployeeType> dataType = employeeTypeRepository.findById(id);
        if (dataType.isEmpty()){
            throw new NotFoundException("jenis pegawai tidak ditemukan");
        } else {
            return dataType.get();
        }
    }

    public void deleteEmployeeType(String id){
        Optional<EmployeeType> dataType = employeeTypeRepository.findById(id);
        if (dataType.isEmpty()){
            throw new NotFoundException("jenis pegawai tidak ditemukan");
        } else {
            EmployeeType data = dataType.get();
            data.setDeleted(true);
            data.setUpdatedAt(LocalDateTime.now());
            employeeTypeRepository.save(data);
        }
    }


}
