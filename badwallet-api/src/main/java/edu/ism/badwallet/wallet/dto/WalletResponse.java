package edu.ism.badwallet.wallet.dto;

import edu.ism.badwallet.wallet.enums.Currency;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class WalletResponse {

    private Long id;

    private String code;

    private String phoneNumber;

    private String email;

    private BigDecimal balance;

    private Currency currency;
}