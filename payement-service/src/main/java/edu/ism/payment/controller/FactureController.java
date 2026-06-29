package edu.ism.payment.controller;

import edu.ism.payment.entity.Facture;
import edu.ism.payment.service.FactureService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/factures")
@RequiredArgsConstructor
public class FactureController {

    private final FactureService factureService;

    @GetMapping("/{walletCode}/current")
    public List<Facture> getCurrentFactures(
            @PathVariable String walletCode,
            @RequestParam(required = false) String unite) {

        if (unite == null || unite.isBlank()) {
            return factureService.getCurrentFactures(walletCode);
        }

        return factureService.getCurrentFacturesByService(walletCode, unite);
    }

    @GetMapping("/{walletCode}/periode")
    public List<Facture> getFacturesByPeriod(
            @PathVariable String walletCode,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate debut,

            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate fin) {

        return factureService.getFacturesByPeriod(
                walletCode,
                debut,
                fin
        );
    }

}