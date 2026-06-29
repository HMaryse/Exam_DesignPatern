package edu.ism.badwallet.wallet.service;

import edu.ism.badwallet.wallet.dto.CreateWalletRequest;
import edu.ism.badwallet.wallet.dto.WalletResponse;

public interface WalletService {

    WalletResponse create(CreateWalletRequest request);

}