package com.sefa.examples.service;

import com.sefa.examples.dto.request.AccountInitialRequest;
import com.sefa.examples.dto.response.AccountInitialResponse;
import com.sefa.examples.model.Account;
import com.sefa.examples.model.Customer;
import com.sefa.examples.model.Transaction;
import com.sefa.examples.model.TransactionEnum;
import com.sefa.examples.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;

    public AccountInitialResponse createAccount(AccountInitialRequest accountInıtialRequest) {
        Customer customer = customerService.findById(accountInıtialRequest.getCustomerId());

        Account account = Account.builder()
                .balance(accountInıtialRequest.getInitialCredit())
                .customer(customer)
                .build();

        if (accountInıtialRequest.getInitialCredit().compareTo(BigDecimal.ONE) > 0) {
            account.getTransactions().add(
                    Transaction.builder()
                            .amount(accountInıtialRequest.getInitialCredit())
                            .transactionType(TransactionEnum.TRANSFER)
                            .account(account)
                            .build()
            );
        }
        return AccountInitialResponse.mapper(accountRepository.save(account));
    }
}
