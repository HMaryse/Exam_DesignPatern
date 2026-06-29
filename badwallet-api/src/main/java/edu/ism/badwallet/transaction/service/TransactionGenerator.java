package edu.ism.badwallet.transaction.service;

import edu.ism.badwallet.transaction.entity.Transaction;
import edu.ism.badwallet.transaction.enums.TransactionType;
import edu.ism.badwallet.wallet.entity.Wallet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;

@Component
public class TransactionGenerator {

    private final Random random = new Random();

    public Transaction generate(Wallet wallet) {

        TransactionType[] types = TransactionType.values();

        TransactionType type = types[random.nextInt(types.length)];

        BigDecimal amount = BigDecimal.valueOf(random.nextInt(9000) + 1000);

        return Transaction.builder()
                .reference(UUID.randomUUID().toString())
                .senderWallet(wallet)
                .receiverWallet(wallet)
                .type(type)
                .amount(amount)
                .fees(BigDecimal.ZERO)
                .build();
    }
}