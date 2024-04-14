package kz.solva.task.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class TransactionDto {
    private UUID id;
    private BigDecimal transactionSum;
    private LocalDateTime transactionDate;
    private LocalDateTime setLimitDate;
    private Long limit;
    private Boolean limitExceeded;
}
