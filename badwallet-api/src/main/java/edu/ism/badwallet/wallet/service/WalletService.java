package edu.ism.badwallet.wallet.service;

import edu.ism.badwallet.wallet.dto.CreateWalletRequest;
import edu.ism.badwallet.wallet.dto.WalletResponse;
import org.springframework.data.domain.Page;

public interface WalletService {

    WalletResponse create(CreateWalletRequest request);

    Page<WalletResponse> getAll(int page, int size);

    WalletResponse getByPhoneNumber(String phoneNumber);

    java.math.BigDecimal getBalance(String phoneNumber);

}