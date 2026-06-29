package edu.ism.badwallet.payment.controller;

import edu.ism.badwallet.payment.dto.WithdrawRequest;
import edu.ism.badwallet.payment.service.WithdrawService;
import edu.ism.badwallet.wallet.dto.WalletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallets")
@RequiredArgsConstructor
public class WithdrawController {

    private final WithdrawService withdrawService;

    @PostMapping("/withdraw")
    public WalletResponse withdraw(
            @Valid @RequestBody WithdrawRequest request) {

        return withdrawService.withdraw(request);

    }

}