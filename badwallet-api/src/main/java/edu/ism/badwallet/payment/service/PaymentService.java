package edu.ism.badwallet.payment.service;

import edu.ism.badwallet.payment.dto.PayFacturesRequest;
import edu.ism.badwallet.payment.dto.PayRequest;
import edu.ism.badwallet.wallet.dto.WalletResponse;

public interface PaymentService {

    WalletResponse pay(PayRequest request);

    WalletResponse payFactures(PayFacturesRequest request);

}