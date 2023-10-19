package orderapp.orderapp.Controller;

import orderapp.orderapp.Model.DTO.ResponseBody;
import orderapp.orderapp.Service.MigrationService;
import orderapp.orderapp.tools.ResponseWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
@RestController
@RequestMapping("/migration")
public class MigrationController {
    private static final Logger logger = LogManager.getLogger(MigrationController.class);

    @Autowired
    private MigrationService migrationService;

    @PostMapping("/users")
    public ResponseEntity<ResponseBody> migrationUser(@RequestParam MultipartFile file) {
        try {
            HashMap<String, Object> data = migrationService.migrationUsers(file);
            return ResponseWriter.success("migration user is success",
                    String.format(
                            "%1%s user success, " +
                            "%2%s user error, " +
                            "%3%s user exist, " +
                            data.get("amount_user_success").toString(),
                            data.get("amount_user_error").toString(),
                            data.get("amount_user_exist").toString()
                    )
            );
        } catch (Exception e) {
            logger.error("migrationUser: " + e.getMessage());
            return ResponseWriter.fail("fail to migrate user", e.getMessage());
        }
    }

    @PostMapping("/bank-account")
    public ResponseEntity<ResponseBody> migrationBankAccount(@RequestParam MultipartFile file) {
        try {
            HashMap<String, Object> data = migrationService.migrationBankAccounts(file);
            return ResponseWriter.success("migration bank is success",
                    String.format(
                            "%1%s bank success, " +
                            "%2%s bank error, " +
                            "%3%s bank exist, " +
                            "%4%s user not found." +
                            data.get("amount_bank_success").toString(),
                            data.get("amount_bank_error").toString(),
                            data.get("amount_bank_exist").toString(),
                            data.get("amount_user_not_found").toString()
                    )
            );
        } catch (Exception e) {
            logger.error("migrationBankAccount: " + e.getMessage());
            return ResponseWriter.fail("fail to migrate bank account", e.getMessage());
        }
    }

    @PostMapping("/work-unit")
    public ResponseEntity<ResponseBody> migrationWorkUnit(@RequestParam MultipartFile file) {
        try {
            HashMap<String, Object> data = migrationService.migrationWorkUnits(file);
            return ResponseWriter.success("migration work unit is success",
                    String.format(
                            "%1%s work unit success, " +
                            "%2%s work unit error, " +
                            "%3%s work unit exist, " +
                            "%4%s user not found." +
                            data.get("amount_work unit_success").toString(),
                            data.get("amount_work unit_error").toString(),
                            data.get("amount_work unit_exist").toString(),
                            data.get("amount_user_not_found").toString()
                    )
            );
        } catch (Exception e) {
            logger.error("migrationWorkUnit: " + e.getMessage());
            return ResponseWriter.fail("fail to migrate work unit", e.getMessage());
        }
    }
}
