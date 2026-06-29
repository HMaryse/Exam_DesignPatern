package edu.ism.badwallet.payment.controller;

import edu.ism.badwallet.payment.dto.PayFacturesRequest;
import edu.ism.badwallet.payment.dto.PayRequest;
import edu.ism.badwallet.payment.service.PaymentService;
import edu.ism.badwallet.wallet.dto.WalletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallets")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/pay")
    public WalletResponse pay(
            @Valid @RequestBody PayRequest request) {

        return paymentService.pay(request);

    }

    @PostMapping("/pay-factures")
    public WalletResponse payFactures(
            @Valid @RequestBody PayFacturesRequest request) {

        return paymentService.payFactures(request);

    }

}