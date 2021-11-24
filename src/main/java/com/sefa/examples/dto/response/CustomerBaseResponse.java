package com.sefa.examples.dto.response;

import com.sefa.examples.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerBaseResponse {

    private String id;
    private String name;
    private String surname;

    public static CustomerBaseResponse mapper(Customer customer){
        return CustomerBaseResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .surname(customer.getSurname())
                .build();
    }
}
