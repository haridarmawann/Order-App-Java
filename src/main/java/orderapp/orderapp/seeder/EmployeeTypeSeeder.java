package orderapp.orderapp.seeder;

import orderapp.orderapp.Model.reference.EmployeeType;
import orderapp.orderapp.Service.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeTypeSeeder {

    @Autowired
    EmployeeTypeService employeeTypeService;

    public void create(){
        EmployeeType employeeType = new EmployeeType();
        employeeType.setTitle("Dosen PNS");
        employeeType.setSlug("dosen-pns");
        employeeType.setDeleted(false);

        EmployeeType employeeType2 = new EmployeeType();
        employeeType2.setTitle("Dosen Tetap");
        employeeType2.setSlug("dosen-tetap");
        employeeType2.setDeleted(false);

        EmployeeType employeeType3 = new EmployeeType();
        employeeType3.setTitle("Dosen Tidak Tetap");
        employeeType3.setSlug("dosen-tidak-tetap");
        employeeType3.setDeleted(false);

        EmployeeType employeeType4 = new EmployeeType();
        employeeType4.setTitle("Tenaga Kependidikan PNS");
        employeeType4.setSlug("tenaga-kependidikan-pns");
        employeeType4.setDeleted(false);

        EmployeeType employeeType5 = new EmployeeType();
        employeeType5.setTitle("Tenaga Kependidikan Tetap");
        employeeType5.setSlug("tenaga-kependidikan-tetap");
        employeeType5.setDeleted(false);

        EmployeeType employeeType6 = new EmployeeType();
        employeeType6.setTitle("Tenaga Kependidikan Tidak Tetap");
        employeeType6.setSlug("tenaga-kependidikan-tidak-tetap");
        employeeType6.setDeleted(false);

        employeeTypeService.insertSeeder(employeeType);
        employeeTypeService.insertSeeder(employeeType2);
        employeeTypeService.insertSeeder(employeeType3);
        employeeTypeService.insertSeeder(employeeType4);
        employeeTypeService.insertSeeder(employeeType5);
        employeeTypeService.insertSeeder(employeeType6);



    }


}
