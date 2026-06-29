package edu.ism.badwallet.payment.service.impl;

import edu.ism.badwallet.payment.dto.PayFacturesRequest;
import edu.ism.badwallet.payment.dto.PayRequest;
import edu.ism.badwallet.payment.service.PaymentService;
import edu.ism.badwallet.wallet.dto.WalletResponse;
import edu.ism.badwallet.wallet.entity.Wallet;
import edu.ism.badwallet.wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final WalletRepository walletRepository;

    @Override
    public WalletResponse pay(PayRequest request) {

        Wallet wallet = walletRepository.findByPhoneNumber(request.getPhoneNumber())
                .orElseThrow(() -> new RuntimeException("Wallet introuvable"));

        if (wallet.getBalance().compareTo(request.getAmount()) < 0) {
            throw new RuntimeException("Solde insuffisant");
        }

        wallet.setBalance(wallet.getBalance().subtract(request.getAmount()));

        walletRepository.save(wallet);

        return buildResponse(wallet);
    }

    @Override
    public WalletResponse payFactures(PayFacturesRequest request) {

        Wallet wallet = walletRepository.findByPhoneNumber(request.getPhoneNumber())
                .orElseThrow(() -> new RuntimeException("Wallet introuvable"));

        //  on simule le paiement des factures.
        // Lorsque le payment-service sera terminé, on appellera l'API externe.

        walletRepository.save(wallet);

        return buildResponse(wallet);
    }

    private WalletResponse buildResponse(Wallet wallet) {
        return WalletResponse.builder()
                .id(wallet.getId())
                .code(wallet.getCode())
                .phoneNumber(wallet.getPhoneNumber())
                .email(wallet.getEmail())
                .balance(wallet.getBalance())
                .currency(wallet.getCurrency())
                .build();
    }
}