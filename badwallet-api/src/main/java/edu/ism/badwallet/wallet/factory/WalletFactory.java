package edu.ism.badwallet.wallet.factory;

import edu.ism.badwallet.wallet.dto.CreateWalletRequest;
import edu.ism.badwallet.wallet.entity.Wallet;

public class WalletFactory {

    private WalletFactory(){}

    public static Wallet create(CreateWalletRequest request){

        return Wallet.builder()
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .code(request.getCode())
                .balance(request.getInitialBalance())
                .currency(request.getCurrency())
                .build();

    }

}