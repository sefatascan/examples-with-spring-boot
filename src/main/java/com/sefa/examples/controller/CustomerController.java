package com.sefa.examples.controller;

import com.sefa.examples.dto.response.CustomerDetailResponse;
import com.sefa.examples.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDetailResponse> getCustomerDetail(@PathVariable("customerId") String customerId){
        return ResponseEntity.ok(customerService.findByIdWithDetail(customerId));
    }
}
