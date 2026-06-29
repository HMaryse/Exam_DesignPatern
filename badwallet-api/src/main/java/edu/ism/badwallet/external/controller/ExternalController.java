package edu.ism.badwallet.external.controller;

import edu.ism.badwallet.external.client.PaymentServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/external")
@RequiredArgsConstructor
public class ExternalController {

    private final PaymentServiceClient paymentServiceClient;

    @GetMapping("/factures/{walletCode}/current")
    public List<Map<String, Object>> getCurrentFactures(
            @PathVariable String walletCode,
            @RequestParam(required = false) String unite) {

        if (unite == null || unite.isBlank()) {
            return paymentServiceClient.getCurrentFactures(walletCode);
        }

        return paymentServiceClient.getCurrentFacturesByService(
                walletCode,
                unite
        );
    }

    @GetMapping("/factures/{walletCode}/periode")
    public List<Map<String, Object>> getFacturesByPeriod(
            @PathVariable String walletCode,
            @RequestParam String debut,
            @RequestParam String fin) {

        return paymentServiceClient.getFacturesByPeriod(
                walletCode,
                debut,
                fin
        );
    }

}