package edu.ism.badwallet.payment.service.impl;

import edu.ism.badwallet.payment.dto.WithdrawRequest;
import edu.ism.badwallet.payment.service.WithdrawService;
import edu.ism.badwallet.wallet.dto.WalletResponse;
import edu.ism.badwallet.wallet.entity.Wallet;
import edu.ism.badwallet.wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WithdrawServiceImpl implements WithdrawService {

    private final WalletRepository walletRepository;

    @Override
    public WalletResponse withdraw(WithdrawRequest request) {

        Wallet wallet = walletRepository.findByPhoneNumber(request.getPhoneNumber())
                .orElseThrow(() -> new RuntimeException("Wallet introuvable"));

        BigDecimal fee = request.getAmount()
                .multiply(new BigDecimal("0.01"));

        if (fee.compareTo(new BigDecimal("5000")) > 0) {
            fee = new BigDecimal("5000");
        }

        BigDecimal total = request.getAmount().add(fee);

        if (wallet.getBalance().compareTo(total) < 0) {
            throw new RuntimeException("Solde insuffisant");
        }

        wallet.setBalance(wallet.getBalance().subtract(total));

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