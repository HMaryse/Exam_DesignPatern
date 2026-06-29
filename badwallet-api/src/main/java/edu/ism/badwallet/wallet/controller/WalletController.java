package edu.ism.badwallet.wallet.controller;

import edu.ism.badwallet.wallet.dto.CreateWalletRequest;
import edu.ism.badwallet.wallet.dto.WalletResponse;
import edu.ism.badwallet.wallet.service.WalletService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/wallets")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WalletResponse createWallet(@Valid @RequestBody CreateWalletRequest request) {

        return walletService.create(request);

    }
    @GetMapping
    public Page<WalletResponse> getAllWallets(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return walletService.getAll(page, size);

    }
    @GetMapping("/{phoneNumber}")
    public WalletResponse getWalletByPhone(
            @PathVariable String phoneNumber) {

        return walletService.getByPhoneNumber(phoneNumber);

    }
    @GetMapping("/{phoneNumber}/balance")
    public BigDecimal getBalance(
            @PathVariable String phoneNumber) {

        return walletService.getBalance(phoneNumber);

    }

}