package com.sefa.examples.dto.response;

import com.sefa.examples.model.Customer;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Builder
@NoArgsConstructor
@Data
public class CustomerDetailResponse {

    private String id;
    private String name;
    private String surname;
    private BigDecimal totalBalance;
    private List<AccountBaseResponse> accounts;

    public static CustomerDetailResponse mapper (Customer customer){
        return null;
    }
}
