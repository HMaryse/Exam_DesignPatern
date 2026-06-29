package edu.ism.badwallet.wallet.controller;

import edu.ism.badwallet.wallet.service.WalletSeederService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wallets")
@RequiredArgsConstructor
public class WalletSeederController {

    private final WalletSeederService walletSeederService;

    @PostMapping("/seed")
        public ResponseEntity<String> seedDatabase(
                @RequestParam(defaultValue = "10") int numWallets,
                @RequestParam(defaultValue = "100") int eventsPerWallet) {

            walletSeederService.seed(numWallets, eventsPerWallet);

            return ResponseEntity.accepted()
                    .body("Wallet seeding started asynchronously.");
        }
}