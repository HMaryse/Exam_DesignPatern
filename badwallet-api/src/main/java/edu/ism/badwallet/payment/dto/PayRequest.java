package edu.ism.badwallet.payment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PayRequest {

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String serviceName;

    @NotNull
    private BigDecimal amount;

}