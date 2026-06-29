package edu.ism.badwallet.wallet.service.impl;

import edu.ism.badwallet.wallet.dto.CreateWalletRequest;
import edu.ism.badwallet.wallet.dto.WalletResponse;
import edu.ism.badwallet.wallet.entity.Wallet;
import edu.ism.badwallet.wallet.factory.WalletFactory;
import edu.ism.badwallet.wallet.repository.WalletRepository;
import edu.ism.badwallet.wallet.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    @Override
    public WalletResponse create(CreateWalletRequest request) {

        if (walletRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new RuntimeException("Ce numéro existe déjà.");
        }

        if (walletRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Cet email existe déjà.");
        }

        if (walletRepository.existsByCode(request.getCode())) {
            throw new RuntimeException("Ce code portefeuille existe déjà.");
        }

        Wallet wallet = WalletFactory.create(request);

        Wallet savedWallet = walletRepository.save(wallet);

        return WalletResponse.builder()
                .id(savedWallet.getId())
                .code(savedWallet.getCode())
                .phoneNumber(savedWallet.getPhoneNumber())
                .email(savedWallet.getEmail())
                .balance(savedWallet.getBalance())
                .currency(savedWallet.getCurrency())
                .build();
    }
}