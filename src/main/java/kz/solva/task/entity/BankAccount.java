package kz.solva.task.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BANK_ACCOUNTS")
public class BankAccount {
    @Id
    private UUID id;
    private Long number;
    private String name;
    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private Client client;
    @OneToMany(mappedBy="bankAccount")
    private Set<Transaction> transactions;
}
