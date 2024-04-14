package kz.solva.task.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kz.solva.task.dto.TransactionDto;
import kz.solva.task.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Tag(name = "Integration transaction controller", description = "Контроллер для запросов от банковских сервисов")
@RequestMapping("integrationApi/v1/transactions")
public class IntegrationTransactionController {

    private final TransactionService transactionService;

    @Operation(summary = "Сохраняет полученную транзакцию")
    @PostMapping("/transaction")
    public void allTransactions(@RequestBody TransactionDto dto) {
        transactionService.save(dto);
    }

}
