package edu.ism.badwallet.payment.dto;

import edu.ism.badwallet.payment.enums.PaymentMethod;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DepositRequest {

    @NotNull
    private BigDecimal amount;

    @NotNull
    private PaymentMethod paymentMethod;

}