package com.sefa.examples.service;

import com.sefa.examples.dto.request.AccountInitialRequest;
import com.sefa.examples.dto.response.AccountDetailResponse;
import com.sefa.examples.dto.response.AccountInitialResponse;
import com.sefa.examples.exception.AccountNotFoundException;
import com.sefa.examples.model.Account;
import com.sefa.examples.model.Customer;
import com.sefa.examples.model.Transaction;
import com.sefa.examples.model.TransactionEnum;
import com.sefa.examples.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final TransactionService transactionService;

    protected Account findById(String accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(accountId));
    }

    protected Account save(Account account) {
        return accountRepository.save(account);
    }

    public AccountDetailResponse getAccountDetail(String accountId) {
        Account account = findById(accountId);
        return AccountDetailResponse.mapper(account);
    }

    public AccountInitialResponse createAccount(AccountInitialRequest accountInıtialRequest) {
        Customer customer = customerService.findById(accountInıtialRequest.getCustomerId());

        Account account = Account.builder()
                .balance(accountInıtialRequest.getInitialCredit())
                .customer(customer)
                .build();

        save(account);

        if (accountInıtialRequest.getInitialCredit().compareTo(BigDecimal.ONE) > 0) {
            transactionService.save(Transaction.builder()
                    .amount(accountInıtialRequest.getInitialCredit())
                    .transactionType(TransactionEnum.TRANSFER)
                    .account(account)
                    .build()
            );

        }
        return AccountInitialResponse.mapper(account);
    }
}
