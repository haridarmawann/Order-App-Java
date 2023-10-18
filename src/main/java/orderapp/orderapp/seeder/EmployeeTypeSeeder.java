package orderapp.orderapp.seeder;

import orderapp.orderapp.Model.reference.EmployeeType;
import orderapp.orderapp.Service.EmployeeTypeService;
import orderapp.orderapp.tools.AppHelper;
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
        employeeType.setTypeId("1");
        employeeType.setCreatedBy("seeder");
        employeeType.setUpdatedBy("seeder");
        employeeType.setCreatedAt(new AppHelper().getCurrentTime());
        employeeType.setDeleted(false);

        EmployeeType employeeType2 = new EmployeeType();
        employeeType2.setTitle("Dosen Tetap");
        employeeType2.setSlug("dosen-tetap");
        employeeType2.setTypeId("2");
        employeeType2.setCreatedBy("seeder");
        employeeType2.setUpdatedBy("seeder");
        employeeType2.setCreatedAt(new AppHelper().getCurrentTime());
        employeeType2.setDeleted(false);

        EmployeeType employeeType3 = new EmployeeType();
        employeeType3.setTitle("Dosen Tidak Tetap");
        employeeType3.setSlug("dosen-tidak-tetap");
        employeeType3.setTypeId("3");
        employeeType3.setCreatedBy("seeder");
        employeeType3.setUpdatedBy("seeder");
        employeeType3.setCreatedAt(new AppHelper().getCurrentTime());
        employeeType3.setDeleted(false);

        EmployeeType employeeType4 = new EmployeeType();
        employeeType4.setTitle("Tenaga Kependidikan PNS");
        employeeType4.setSlug("tenaga-kependidikan-pns");
        employeeType4.setTypeId("4");
        employeeType4.setCreatedBy("seeder");
        employeeType4.setUpdatedBy("seeder");
        employeeType4.setCreatedAt(new AppHelper().getCurrentTime());
        employeeType4.setDeleted(false);

        EmployeeType employeeType5 = new EmployeeType();
        employeeType5.setTitle("Tenaga Kependidikan Tetap");
        employeeType5.setSlug("tenaga-kependidikan-tetap");
        employeeType5.setTypeId("5");
        employeeType5.setCreatedBy("seeder");
        employeeType5.setUpdatedBy("seeder");
        employeeType5.setCreatedAt(new AppHelper().getCurrentTime());
        employeeType5.setDeleted(false);

        EmployeeType employeeType6 = new EmployeeType();
        employeeType6.setTitle("Tenaga Kependidikan Tidak Tetap");
        employeeType6.setSlug("tenaga-kependidikan-tidak-tetap");
        employeeType6.setTypeId("6");
        employeeType6.setCreatedBy("seeder");
        employeeType6.setUpdatedBy("seeder");
        employeeType6.setCreatedAt(new AppHelper().getCurrentTime());
        employeeType6.setDeleted(false);

        employeeTypeService.insertSeeder(employeeType);
        employeeTypeService.insertSeeder(employeeType2);
        employeeTypeService.insertSeeder(employeeType3);
        employeeTypeService.insertSeeder(employeeType4);
        employeeTypeService.insertSeeder(employeeType5);
        employeeTypeService.insertSeeder(employeeType6);



    }


}
