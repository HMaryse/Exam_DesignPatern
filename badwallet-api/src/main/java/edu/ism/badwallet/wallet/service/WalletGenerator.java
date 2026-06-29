package edu.ism.badwallet.wallet.service;

import edu.ism.badwallet.wallet.entity.Wallet;
import edu.ism.badwallet.wallet.enums.Currency;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;

@Component
public class WalletGenerator {

    private final Random random = new Random();

    public Wallet generate(int index) {

        return Wallet.builder()
                .code(String.format("WLT-%07d", index))
                .phoneNumber("+2217700000" + String.format("%02d", index))
                .email("client" + index + "@gmail.com")
                .balance(BigDecimal.valueOf(random.nextInt(90000) + 10000))
                .currency(Currency.XOF)
                .build();

    }

}