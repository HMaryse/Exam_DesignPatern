package edu.ism.badwallet.payment.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class WithdrawRequest {

    @NotNull
    private String phoneNumber;

    @NotNull
    private BigDecimal amount;

}