package com.sefa.examples.dto.response;

import com.sefa.examples.model.Transaction;
import com.sefa.examples.model.TransactionEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionResponse {

    private String id;
    private LocalDateTime transactionDate;
    private BigDecimal amount;
    private TransactionEnum transactionType;

    public static TransactionResponse mapper(Transaction transaction) {
        return TransactionResponse.builder()
                .id(transaction.getId())
                .transactionDate(transaction.getTransactionDate())
                .amount(transaction.getAmount())
                .transactionType(transaction.getTransactionType())
                .build();
    }
}
