package edu.ism.badwallet.payment.service.impl;

import edu.ism.badwallet.payment.dto.TransferRequest;
import edu.ism.badwallet.payment.service.TransferService;
import edu.ism.badwallet.wallet.dto.WalletResponse;
import edu.ism.badwallet.wallet.entity.Wallet;
import edu.ism.badwallet.wallet.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {

    private final WalletRepository walletRepository;

    @Override
    public WalletResponse transfer(TransferRequest request) {

        Wallet sender = walletRepository.findByPhoneNumber(request.getSenderPhone())
                .orElseThrow(() -> new RuntimeException("Expéditeur introuvable"));

        Wallet receiver = walletRepository.findByPhoneNumber(request.getReceiverPhone())
                .orElseThrow(() -> new RuntimeException("Destinataire introuvable"));

        if (sender.getBalance().compareTo(request.getAmount()) < 0) {
            throw new RuntimeException("Solde insuffisant");
        }

        sender.setBalance(sender.getBalance().subtract(request.getAmount()));
        receiver.setBalance(receiver.getBalance().add(request.getAmount()));

        walletRepository.save(sender);
        walletRepository.save(receiver);

        return WalletResponse.builder()
                .id(sender.getId())
                .code(sender.getCode())
                .phoneNumber(sender.getPhoneNumber())
                .email(sender.getEmail())
                .balance(sender.getBalance())
                .currency(sender.getCurrency())
                .build();
    }
}