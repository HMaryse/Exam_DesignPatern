package edu.ism.payment.service;

import edu.ism.payment.entity.Facture;

import java.time.LocalDate;
import java.util.List;

public interface FactureService {

    List<Facture> getCurrentFactures(String walletCode);

    List<Facture> getCurrentFacturesByService(
            String walletCode,
            String serviceName
    );

    List<Facture> getFacturesByPeriod(
            String walletCode,
            LocalDate debut,
            LocalDate fin
    );

}