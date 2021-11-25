package com.sefa.examples.service;

import com.sefa.examples.dto.request.CustomerRequest;
import com.sefa.examples.dto.response.CustomerBaseResponse;
import com.sefa.examples.dto.response.CustomerDetailResponse;
import com.sefa.examples.exception.CustomerNotFoundException;
import com.sefa.examples.model.Customer;
import com.sefa.examples.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    protected Customer findById(String customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
    }

    public CustomerDetailResponse findByIdWithDetail(String customerId) {
        return CustomerDetailResponse.mapper(findById(customerId));
    }

    public CustomerBaseResponse createCustomer(CustomerRequest customerRequest){
        Customer customer = Customer.builder()
                .name(customerRequest.getName())
                .surname(customerRequest.getSurname())
                .build();
        customerRepository.save(customer);
        return CustomerBaseResponse.mapper(customer);
    }
}
