package com.sefa.examples.dto.response;

import com.sefa.examples.model.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountDetailResponse {

    private String id;
    private LocalDateTime createdAt;
    private BigDecimal balance;
    private CustomerBaseResponse customer;
    private List<TransactionResponse> transactions;

    public static AccountDetailResponse mapper(Account account) {
        return AccountDetailResponse.builder()
                .id(account.getId())
                .createdAt(account.getCreatedAt())
                .balance(account.getBalance())
                .customer(CustomerBaseResponse.mapper(account.getCustomer()))
                .transactions(account.getTransactions().stream()
                        .map(TransactionResponse::mapper)
                        .collect(Collectors.toList()))
                .build();
    }
}
