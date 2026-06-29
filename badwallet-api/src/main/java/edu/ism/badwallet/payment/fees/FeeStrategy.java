package edu.ism.badwallet.payment.fees;

import java.math.BigDecimal;

public interface FeeStrategy {

    BigDecimal calculate(BigDecimal amount);

}