package edu.ism.badwallet.payment.controller;

import edu.ism.badwallet.payment.dto.TransferRequest;
import edu.ism.badwallet.payment.service.TransferService;
import edu.ism.badwallet.wallet.dto.WalletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallets")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @PostMapping("/transfer")
    public WalletResponse transfer(@Valid @RequestBody TransferRequest request) {

        return transferService.transfer(request);

    }

}