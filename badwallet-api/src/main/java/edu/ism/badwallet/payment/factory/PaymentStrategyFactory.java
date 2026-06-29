package edu.ism.badwallet.payment.factory;

import edu.ism.badwallet.payment.enums.PaymentMethod;
import edu.ism.badwallet.payment.strategy.CreditCardPayment;
import edu.ism.badwallet.payment.strategy.PaymentStrategy;
import edu.ism.badwallet.payment.strategy.WalletTargetPayment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentStrategyFactory {

    private final CreditCardPayment creditCardPayment;
    private final WalletTargetPayment walletTargetPayment;

    public PaymentStrategy getStrategy(PaymentMethod method) {

        return switch (method) {

            case CREDIT_CARD -> creditCardPayment;

            case WALLET_TARGET -> walletTargetPayment;

        };

    }

}