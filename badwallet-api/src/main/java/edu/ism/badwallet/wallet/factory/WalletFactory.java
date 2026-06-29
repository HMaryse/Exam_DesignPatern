package edu.ism.badwallet.wallet.factory;

import edu.ism.badwallet.wallet.dto.CreateWalletRequest;
import edu.ism.badwallet.wallet.entity.Wallet;

public class WalletFactory {

    private WalletFactory() {
    }

    public static Wallet create(CreateWalletRequest request) {

        return Wallet.builder()
                .code(request.getCode())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .balance(request.getInitialBalance())
                .currency(request.getCurrency())
                .build();
    }
}