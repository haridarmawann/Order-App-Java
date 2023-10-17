package orderapp.orderapp;

import orderapp.orderapp.seeder.EmployeeTypeSeeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class InitData implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    EmployeeTypeSeeder employeeTypeSeeder;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
    employeeTypeSeeder.create();

    }
}
