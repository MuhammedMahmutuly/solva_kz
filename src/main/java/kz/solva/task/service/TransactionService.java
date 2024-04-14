package kz.solva.task.service;

import kz.solva.task.dto.TransactionDto;

import java.util.List;
import java.util.UUID;

public interface TransactionService {
    List<TransactionDto> getOverLimitTransactions(UUID clientId);
    void setLimitByClientIdAndBankAccountId(Long limit, UUID bankAccountId);

    List<Long> getAllLimitsByClientIdAndBankAccountId(UUID bankAccountId);

    void save(TransactionDto dto);
}
