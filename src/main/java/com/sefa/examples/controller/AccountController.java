package com.sefa.examples.controller;

import com.sefa.examples.dto.request.AccountInitialRequest;
import com.sefa.examples.dto.response.AccountDetailResponse;
import com.sefa.examples.dto.response.AccountInitialResponse;
import com.sefa.examples.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDetailResponse> getAccountDetail(@PathVariable String accountId) {
        return ResponseEntity.ok(accountService.getAccountDetail(accountId));
    }

    @PostMapping
    public ResponseEntity<AccountInitialResponse> createAccount(@RequestBody AccountInitialRequest accountInıtialRequest) {
        return ResponseEntity.ok(accountService.createAccount(accountInıtialRequest));
    }
}
