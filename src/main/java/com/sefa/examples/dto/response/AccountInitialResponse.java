package com.sefa.examples.dto.response;

import com.sefa.examples.model.Account;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@Data
public class AccountInitialResponse {

    private String id;
    private LocalDateTime createdAt;
    private BigDecimal balance;
    private CustomerBaseResponse customer;

    public static AccountInitialResponse mapper(Account account){
        return AccountInitialResponse.builder()
                .id(account.getId())
                .createdAt(account.getCreatedAt())
                .balance(account.getBalance())
                .customer(CustomerBaseResponse.mapper(account.getCustomer()))
                .build();
    }
}
