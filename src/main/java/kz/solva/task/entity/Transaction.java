package kz.solva.task.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TRANSACTIONS")
public class Transaction {
    @Id
    private UUID id;
    private BigDecimal transactionSum;
    private LocalDateTime transactionDate;
    private LocalDateTime setLimitDate;
    private Long limit;
    private Boolean limitExceeded;
    @ManyToOne
    @JoinColumn(name="bank_account_id", nullable=false)
    private BankAccount bankAccount;
}
