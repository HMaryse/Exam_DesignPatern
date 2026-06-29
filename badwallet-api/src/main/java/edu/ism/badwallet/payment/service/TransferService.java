package edu.ism.badwallet.payment.service;

import edu.ism.badwallet.payment.dto.TransferRequest;
import edu.ism.badwallet.wallet.dto.WalletResponse;

public interface TransferService {

    WalletResponse transfer(TransferRequest request);

}