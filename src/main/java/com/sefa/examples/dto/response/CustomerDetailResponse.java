package com.sefa.examples.dto.response;

import com.sefa.examples.model.Account;
import com.sefa.examples.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDetailResponse {

    private String id;
    private String name;
    private String surname;
    private BigDecimal totalBalance;
    private List<AccountBaseResponse> accounts;

    public static CustomerDetailResponse mapper(Customer customer) {
        Stream<Account> accountStream = customer.getAccounts().stream();
        return CustomerDetailResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .surname(customer.getSurname())
                .totalBalance(accountStream
                        .map(Account::getBalance)
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .accounts(accountStream
                        .map(AccountBaseResponse::mapper)
                        .collect(Collectors.toList()))
                .build();
    }
}
