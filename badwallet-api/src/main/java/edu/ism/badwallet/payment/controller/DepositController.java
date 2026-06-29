package edu.ism.badwallet.payment.controller;

import edu.ism.badwallet.payment.dto.DepositRequest;
import edu.ism.badwallet.payment.service.DepositService;
import edu.ism.badwallet.wallet.dto.WalletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallets")
@RequiredArgsConstructor
public class DepositController {

    private final DepositService depositService;

    @PostMapping("/{id}/deposit")
    public WalletResponse deposit(
            @PathVariable Long id,
            @Valid @RequestBody DepositRequest request) {

        return depositService.deposit(id, request);

    }
}