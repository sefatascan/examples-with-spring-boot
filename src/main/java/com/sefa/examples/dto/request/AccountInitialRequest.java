package com.sefa.examples.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountInitialRequest {

    private String customerId;
    private BigDecimal initialCredit;
}
