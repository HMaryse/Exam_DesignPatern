package edu.ism.payment.service.impl;

import edu.ism.payment.entity.Facture;
import edu.ism.payment.repository.FactureRepository;
import edu.ism.payment.service.FactureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FactureServiceImpl implements FactureService {

    private final FactureRepository factureRepository;

    @Override
    public List<Facture> getCurrentFactures(String walletCode) {

        return factureRepository.findByWalletCodeAndPaidFalse(walletCode);

    }

    @Override
    public List<Facture> getCurrentFacturesByService(
            String walletCode,
            String serviceName) {

        return factureRepository.findByWalletCodeAndServiceNameAndPaidFalse(
                walletCode,
                serviceName
        );

    }

    @Override
    public List<Facture> getFacturesByPeriod(
            String walletCode,
            LocalDate debut,
            LocalDate fin) {

        return factureRepository.findByWalletCodeAndDueDateBetween(
                walletCode,
                debut,
                fin
        );

    }

}