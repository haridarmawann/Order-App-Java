package orderapp.orderapp.Service;

import orderapp.orderapp.Model.BankAccount;
import orderapp.orderapp.Model.DTO.Address;
import orderapp.orderapp.Model.DTO.PhysicalDescription;
import orderapp.orderapp.Model.Employee;
import orderapp.orderapp.Model.reference.Unit;
import orderapp.orderapp.Repository.BankAccountRepository;
import orderapp.orderapp.Repository.EmployeeRepository;
import orderapp.orderapp.storage.FileSystemStorageService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

@Service
public class MigrationService {
    private static final Logger logger = LogManager.getLogger(MigrationService.class);

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private FileSystemStorageService filesStorageService;

    public HashMap<String, Object> migrationUsers(MultipartFile file) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        filesStorageService.saveFile(file, file.getOriginalFilename().split("\\.")[0], "/migration/users");
        long end = System.currentTimeMillis();
        System.out.println("CSV Time process: " + (end - start) + " ms.");

        Path fileDir = Paths.get("files");
        String dirLocation = fileDir.toFile().getAbsolutePath();
        File initialFile = new File(dirLocation + "/migration/users/" + file.getOriginalFilename());
        InputStream targetStream = new FileInputStream(initialFile);

        List<Employee> datalist = new ArrayList<>();
        List<Employee> errorList = new ArrayList<>();
        List<String> userExist = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(targetStream, StandardCharsets.UTF_8));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim().withDelimiter(';').withQuote('"'))) {
            start = System.currentTimeMillis();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            end = System.currentTimeMillis();
            logger.info("migrationUsers GET RECORDS: " + (end - start));
            int count = 0;
            for (CSVRecord csvRecord : csvRecords) {
                logger.info(count++ + " ==================");
                String userId = csvRecord.get("lecturer_id");
                if (!employeeRepository.existsByUserId(userId)) {
                    logger.info("Processing user_id: " + userId);
                    Employee employee = new Employee();
                    employee.setUserId(userId);
                    employee.setName(csvRecord.get("full_name"));
                    employee.setFrontDegree(csvRecord.get("front_degree"));
                    employee.setBehindDegree(csvRecord.get("behind_degree"));
                    employee.setNip(csvRecord.get("nip"));
                    employee.setNidn(csvRecord.get("nidn"));
                    employee.setBirthPlace(csvRecord.get("place_of_birth"));
                    employee.setBirthDate(LocalDate.parse(csvRecord.get("date_of_birth")));
                    employee.setBirthFile(csvRecord.get("birth_document"));
                    employee.setReligion(csvRecord.get("religion"));
                    employee.setGender(csvRecord.get("gender"));
                    employee.setMaritalStatus(csvRecord.get("marital_status"));
                    employee.setWorkUnitId(csvRecord.get("work_unit_id"));
                    employee.setWorkInit(csvRecord.get("work_unit"));
                    employee.setWorkUnitName(csvRecord.get("work_unit_name"));

                    Address address = new Address();
                    address.setStreet(csvRecord.get("street"));
                    address.setVillage(csvRecord.get("village"));
                    address.setSubDistrict(csvRecord.get("sub_district"));
                    address.setDistrict(csvRecord.get("district"));
                    address.setProvince(csvRecord.get("province"));
                    employee.setAddress(address);

                    employee.setPhone(csvRecord.get("phone"));
                    employee.setEmail(csvRecord.get("email"));
                    employee.setEmailUSU(csvRecord.get("email_usu"));
                    employee.setNpwp(csvRecord.get("npwp"));
                    employee.setStatus(Integer.parseInt(csvRecord.get("status")));

                    employee.setSisterUuid(csvRecord.get("sister_uuid"));
                    employee.setPhoto(csvRecord.get("photo"));
                    employee.setType(csvRecord.get("type"));
                    employee.setTypeName(csvRecord.get("type_str"));

                    employee.setPassword(csvRecord.get("password"));
                    employee.setResetPasswordKey(csvRecord.get("reset_password_key"));
                    employee.setStudyProgramId(csvRecord.get("study_program_id"));
                    employee.setStudyProgram(csvRecord.get("study_program"));

                    try {
                        datalist.add(employee);
                        logger.info("finish");
                    } catch (Exception e) {
                        e.printStackTrace();
                        errorList.add(employee);
                        logger.info("migrationUsers: failed to save user " + userId);
                    }
                } else {
                    userExist.add(userId);
                    logger.info("migrationUsers: user " + userId + " is exist");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            logger.info("migrationUsers: error to read file");
        }
        employeeRepository.saveAll(datalist);

        HashMap<String, Object> res = new HashMap<>();
        res.put("amount_user_success", datalist.size());
        res.put("amount_user_error", errorList.size());
        res.put("amount_user_exist", userExist.size());
        return res;
    }

    public HashMap<String, Object> migrationBankAccounts(MultipartFile file) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        filesStorageService.saveFile(file, file.getOriginalFilename().split("\\.")[0], "/migration/bank-account");
        long end = System.currentTimeMillis();
        System.out.println("CSV Time process: " + (end - start) + " ms.");

        Path fileDir = Paths.get("files");
        String dirLocation = fileDir.toFile().getAbsolutePath();
        File initialFile = new File(dirLocation + "/migration/bank-account/" + file.getOriginalFilename());
        InputStream targetStream = new FileInputStream(initialFile);

        List<BankAccount> datalist = new ArrayList<>();
        List<BankAccount> errorList = new ArrayList<>();
        List<String> bankExist = new ArrayList<>();
        List<String> userNotFound = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(targetStream, StandardCharsets.UTF_8));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim().withDelimiter(';').withQuote('"'))) {
            start = System.currentTimeMillis();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            end = System.currentTimeMillis();
            logger.info("migrationBankAccounts GET RECORDS: " + (end - start));
            int count = 0;
            for (CSVRecord csvRecord : csvRecords) {
                logger.info(count++ + " ==================");
                String userId = csvRecord.get("lecturer_id");
                if (employeeRepository.existsByUserId(userId)) {
                    String accountNumber = csvRecord.get("account_number");
                    if (!bankAccountRepository.existsByUserIdAAndAccountNumber(userId, accountNumber)) {
                        logger.info("Processing user_id: " + userId);

                        String userIdObject = employeeRepository.findByUserId(userId).get().getUserId();
                        BankAccount bankAccount = new BankAccount();
                        bankAccount.setUserId(userIdObject);
                        bankAccount.setUserIdSimsdm(userId);

                        bankAccount.setBankId(csvRecord.get("bank_id"));
                        ArrayList<String> bank = new ArrayList<>(Arrays.asList("Bank Mandiri", "BNI", "BTN", "Bank Sumut", "BCA", "BRI", "Bank Syariah Mandiri",
                                "BRI Syariah", "CIMB Niaga", "CIMB", "BTPN Jenius", "BSI", "Maybank", "Bank Mega", "Bank Mega Syariah",
                                "Bank Bukopin", "Bank Bukopin Syariah", "Bank Permata", "Bank Permata Syariah", "BCA Syariah"));
                        bankAccount.setBankName(bank.get(Integer.parseInt(bankAccount.getBankId())));

                        bankAccount.setAccountName(csvRecord.get("holder_name"));
                        bankAccount.setAccountNumber(accountNumber);

                        bankAccount.setPaymentId(Integer.parseInt(csvRecord.get("payment_id")));
//                        ArrayList<String> payment = new ArrayList<>(Arrays.asList("Rutin", "Adhoc", "Uang Makan"));
                        try {
                            datalist.add(bankAccount);
                            logger.info("finish");
                        } catch (Exception e) {
                            e.printStackTrace();
                            errorList.add(bankAccount);
                            logger.info("migrationBankAccounts: failed to save bank " + userId);
                        }
                    } else {
                        bankExist.add(userId);
                        logger.info("migrationBankAccounts: bank " + userId + " with " + accountNumber + " is exist");
                    }
                } else {
                    userNotFound.add(userId);
                    logger.info("migrationBankAccounts: user " + userId + " not found");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            logger.info("migrationBankAccounts: error to read file");
        }
        bankAccountRepository.saveAll(datalist);

        HashMap<String, Object> res = new HashMap<>();
        res.put("amount_bank_success", datalist.size());
        res.put("amount_bank_error", errorList.size());
        res.put("amount_bank_exist", bankExist.size());
        res.put("amount_user_not_found", userNotFound.size());
        return res;
    }

    public HashMap<String, Object> migrationWorkUnits(MultipartFile file) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        filesStorageService.saveFile(file, file.getOriginalFilename().split("\\.")[0], "/migration/work-unit");
        long end = System.currentTimeMillis();
        System.out.println("CSV Time process: " + (end - start) + " ms.");

        Path fileDir = Paths.get("files");
        String dirLocation = fileDir.toFile().getAbsolutePath();
        File initialFile = new File(dirLocation + "/migration/work-unit/" + file.getOriginalFilename());
        InputStream targetStream = new FileInputStream(initialFile);

        List<BankAccount> datalist = new ArrayList<>();
        List<BankAccount> errorList = new ArrayList<>();
        List<String> bankExist = new ArrayList<>();
        List<String> userNotFound = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(targetStream, StandardCharsets.UTF_8));
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim().withDelimiter(';').withQuote('"'))) {
            start = System.currentTimeMillis();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            end = System.currentTimeMillis();
            logger.info("migrationBankAccounts GET RECORDS: " + (end - start));
            int count = 0;
            for (CSVRecord csvRecord : csvRecords) {
                logger.info(count++ + " ==================");
                String userId = csvRecord.get("lecturer_id");
                if (employeeRepository.existsByUserId(userId)) {
                    String decreeNumber = csvRecord.get("decree_number");
                    if (!workUnitRepository.existsByUserIdAAndAccountNumber(userId, decreeNumber)) {
                        logger.info("Processing user_id: " + userId);

                        String userIdObject = employeeRepository.findByUserId(userId).get().getUserId();
                        BankAccount bankAccount = new BankAccount();
                        bankAccount.setUserId(userIdObject);
                        bankAccount.setUserIdSimsdm(userId);

                        bankAccount.setBankId(csvRecord.get("bank_id"));
                        ArrayList<String> bank = new ArrayList<>(Arrays.asList("Bank Mandiri", "BNI", "BTN", "Bank Sumut", "BCA", "BRI", "Bank Syariah Mandiri",
                                "BRI Syariah", "CIMB Niaga", "CIMB", "BTPN Jenius", "BSI", "Maybank", "Bank Mega", "Bank Mega Syariah",
                                "Bank Bukopin", "Bank Bukopin Syariah", "Bank Permata", "Bank Permata Syariah", "BCA Syariah"));
                        bankAccount.setBankName(bank.get(Integer.parseInt(bankAccount.getBankId())));

                        bankAccount.setAccountName(csvRecord.get("holder_name"));
                        bankAccount.setAccountNumber(accountNumber);

                        bankAccount.setPaymentId(Integer.parseInt(csvRecord.get("payment_id")));
//                        ArrayList<String> payment = new ArrayList<>(Arrays.asList("Rutin", "Adhoc", "Uang Makan"));
                        try {
                            datalist.add(bankAccount);
                            logger.info("finish");
                        } catch (Exception e) {
                            e.printStackTrace();
                            errorList.add(bankAccount);
                            logger.info("migrationWorkUnits: failed to save work unit " + userId);
                        }
                    } else {
                        bankExist.add(userId);
                        logger.info("migrationWorkUnits: work unit " + userId + " with " + decreeNumber + " is exist");
                    }
                } else {
                    userNotFound.add(userId);
                    logger.info("migrationWorkUnits: user " + userId + " not found");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            logger.info("migrationWorkUnits: error to read file");
        }
        bankAccountRepository.saveAll(datalist);

        HashMap<String, Object> res = new HashMap<>();
        res.put("amount_work_unit_success", datalist.size());
        res.put("amount_work_unit_error", errorList.size());
        res.put("amount_work_unit_exist", bankExist.size());
        res.put("amount_user_not_found", userNotFound.size());
        return res;
    }
}
