package edu.ism.badwallet.payment.strategy;

import edu.ism.badwallet.wallet.entity.Wallet;

import java.math.BigDecimal;

public interface PaymentStrategy {

    void deposit(Wallet wallet, BigDecimal amount);

}