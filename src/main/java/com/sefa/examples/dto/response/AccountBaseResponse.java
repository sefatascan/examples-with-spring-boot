package com.sefa.examples.dto.response;

import com.sefa.examples.model.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountBaseResponse {

    private String id;
    private LocalDateTime createdAt;
    private BigDecimal balance;


    public static AccountBaseResponse mapper(Account account) {
        return AccountBaseResponse.builder()
                .id(account.getId())
                .createdAt(account.getCreatedAt())
                .balance(account.getBalance())
                .build();
    }
}
