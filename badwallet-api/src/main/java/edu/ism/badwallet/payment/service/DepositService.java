package edu.ism.badwallet.payment.service;

import edu.ism.badwallet.payment.dto.DepositRequest;
import edu.ism.badwallet.wallet.dto.WalletResponse;

public interface DepositService {

    WalletResponse deposit(Long walletId, DepositRequest request);

}