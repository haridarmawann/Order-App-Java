package orderapp.orderapp.Repository;

import orderapp.orderapp.Model.BankAccount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankAccountRepository extends MongoRepository<BankAccount,String> {
    boolean existsByUserIdAAndAccountNumber(String userId, String accountNumber);
}
