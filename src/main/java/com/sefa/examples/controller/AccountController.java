package com.sefa.examples.controller;

import com.sefa.examples.dto.request.AccountInitialRequest;
import com.sefa.examples.dto.response.AccountInitialResponse;
import com.sefa.examples.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public String getAccountDetail() {
        return null;
    }

    @PostMapping()
    public ResponseEntity<AccountInitialResponse> createAccount(AccountInitialRequest accountInıtialRequest) {
        return ResponseEntity.ok(accountService.createAccount(accountInıtialRequest));
    }
}
