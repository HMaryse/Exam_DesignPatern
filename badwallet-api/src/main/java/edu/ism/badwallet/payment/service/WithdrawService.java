package edu.ism.badwallet.payment.service;

import edu.ism.badwallet.payment.dto.WithdrawRequest;
import edu.ism.badwallet.wallet.dto.WalletResponse;

public interface WithdrawService {

    WalletResponse withdraw(WithdrawRequest request);

}