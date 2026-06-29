package edu.ism.badwallet.payment.fees;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class WithdrawFeeStrategy implements FeeStrategy {

    private static final BigDecimal RATE = new BigDecimal("0.01");
    private static final BigDecimal MAX_FEE = new BigDecimal("5000");

    @Override
    public BigDecimal calculate(BigDecimal amount) {

        BigDecimal fee = amount.multiply(RATE);

        if (fee.compareTo(MAX_FEE) > 0) {
            return MAX_FEE;
        }

        return fee;
    }
}