package edu.ism.badwallet.payment.strategy;

import edu.ism.badwallet.wallet.entity.Wallet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CreditCardPayment implements PaymentStrategy {

    @Override
    public void deposit(Wallet wallet, BigDecimal amount) {

        wallet.setBalance(
                wallet.getBalance().add(amount)
        );

    }

}