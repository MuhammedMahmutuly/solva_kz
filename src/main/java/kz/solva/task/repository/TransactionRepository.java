package kz.solva.task.repository;

import kz.solva.task.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    @Query("from Transaction t where t.bankAccount.client.id = :clientId and t.limitExceeded = true")
    List<Transaction> getOverLimitTransactions(@Param("clientId") UUID clientId);

    @Query("select t.limit from Transaction t where t.bankAccount.id = :bankAccountId and t.limitExceeded = true")
    List<Long> getAllLimitsByClientIdAndBankAccountId(@Param("bankAccountId") UUID bankAccountId);
}
