package edu.ism.badwallet.wallet.dto;

import edu.ism.badwallet.wallet.enums.Currency;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateWalletRequest {

    @NotBlank
    private String phoneNumber;

    @NotBlank
    @Email
    private String email;

    @NotNull
    private BigDecimal initialBalance;

    @NotBlank
    private String code;

    @NotNull
    private Currency currency;
}