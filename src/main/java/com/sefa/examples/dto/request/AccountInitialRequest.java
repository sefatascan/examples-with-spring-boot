package com.sefa.examples.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@Data
public class AccountInitialRequest {

    private String customerId;
    private BigDecimal initialCredit;
}
