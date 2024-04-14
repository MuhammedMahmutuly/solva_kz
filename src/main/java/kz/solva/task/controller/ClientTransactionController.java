package kz.solva.task.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.solva.task.dto.TransactionDto;
import kz.solva.task.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Tag(name = "Client transaction controller", description = "Контроллер для клиентских запросов")
@RequestMapping("/clientApi/v1/transactions")
public class ClientTransactionController {

    private final TransactionService transactionService;

    @Operation(summary = "Возвращает все транзакций превысившых лимит")
    @GetMapping("/allOverLimitTransactions")
    public List<TransactionDto> allTransactions(UUID clientId) {
        return transactionService.getOverLimitTransactions(clientId);
    }

    @Operation(summary = "Установка лимита")
    @PutMapping("/limit")
    public void allTransactions(Long limit, UUID bankAccountId) {
        transactionService.setLimitByClientIdAndBankAccountId(limit, bankAccountId);
    }

    @Operation(summary = "Возвращает все лимиты")
    @GetMapping("/allLimits")
    public List<Long> allLimits(UUID bankAccountId) {
        return transactionService.getAllLimitsByClientIdAndBankAccountId(bankAccountId);
    }

}
