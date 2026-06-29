package edu.ism.badwallet.payment.service.impl;

import edu.ism.badwallet.payment.dto.DepositRequest;
import edu.ism.badwallet.payment.factory.PaymentStrategyFactory;
import edu.ism.badwallet.payment.service.DepositService;
import edu.ism.badwallet.wallet.dto.WalletResponse;
import edu.ism.badwallet.wallet.entity.Wallet;
import edu.ism.badwallet.wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepositServiceImpl implements DepositService {

    private final WalletRepository walletRepository;
    private final PaymentStrategyFactory paymentStrategyFactory;

    @Override
    public WalletResponse deposit(Long walletId, DepositRequest request) {

        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet introuvable"));

        paymentStrategyFactory
                .getStrategy(request.getPaymentMethod())
                .deposit(wallet, request.getAmount());

        walletRepository.save(wallet);

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