package edu.ism.badwallet.transaction.repository;

import edu.ism.badwallet.transaction.entity.Transaction;
import edu.ism.badwallet.wallet.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findBySenderWallet(Wallet senderWallet);

    List<Transaction> findByReceiverWallet(Wallet receiverWallet);

}