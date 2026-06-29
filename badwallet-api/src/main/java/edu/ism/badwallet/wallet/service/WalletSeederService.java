package edu.ism.badwallet.wallet.service;

import edu.ism.badwallet.transaction.entity.Transaction;
import edu.ism.badwallet.transaction.repository.TransactionRepository;
import edu.ism.badwallet.transaction.service.TransactionGenerator;
import edu.ism.badwallet.wallet.entity.Wallet;
import edu.ism.badwallet.wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WalletSeederService {

    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;
    private final WalletGenerator walletGenerator;
    private final TransactionGenerator transactionGenerator;

    @Async
    @Transactional
    public void seed(int numWallets, int eventsPerWallet) {

        for (int i = 1; i <= numWallets; i++) {

            Wallet wallet = walletGenerator.generate(i);

            wallet = walletRepository.save(wallet);

            for (int j = 1; j <= eventsPerWallet; j++) {

                Transaction transaction = transactionGenerator.generate(wallet);

                transactionRepository.save(transaction);

            }

        }

    }
}