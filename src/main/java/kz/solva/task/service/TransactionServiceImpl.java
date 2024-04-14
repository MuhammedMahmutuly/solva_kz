package kz.solva.task.service;

import kz.solva.task.dto.TransactionDto;
import kz.solva.task.entity.Transaction;
import kz.solva.task.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    @Override
    public List<TransactionDto> getOverLimitTransactions(UUID clientId) {
        List<Transaction> transactions = transactionRepository.getOverLimitTransactions(clientId);

        return null;
    }

    @Override
    public void setLimitByClientIdAndBankAccountId(Long limit, UUID bankAccountId) {
        List<Transaction> transactions = transactionRepository.findAll();
        Transaction transaction = transactions.stream()
                        .filter(t -> t.getBankAccount().getId().equals(bankAccountId))
                                .findFirst().orElseThrow();

        transaction.setLimit(limit);
        transactionRepository.save(transaction);
    }

    @Override
    public List<Long> getAllLimitsByClientIdAndBankAccountId(UUID bankAccountId) {
        return transactionRepository.getAllLimitsByClientIdAndBankAccountId(bankAccountId);
    }

    @Override
    public void save(TransactionDto dto) {
        transactionRepository.save(null);
    }
}
