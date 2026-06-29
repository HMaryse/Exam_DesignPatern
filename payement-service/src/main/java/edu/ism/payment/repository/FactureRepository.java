package edu.ism.payment.repository;

import edu.ism.payment.entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FactureRepository extends JpaRepository<Facture, Long> {

    List<Facture> findByWalletCodeAndPaidFalse(String walletCode);

    List<Facture> findByWalletCodeAndServiceNameAndPaidFalse(
            String walletCode,
            String serviceName
    );

    List<Facture> findByWalletCodeAndDueDateBetween(
            String walletCode,
            LocalDate debut,
            LocalDate fin
    );

    List<Facture> findByReferenceIn(List<String> references);

}