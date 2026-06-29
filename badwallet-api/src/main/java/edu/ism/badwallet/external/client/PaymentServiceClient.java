package edu.ism.badwallet.external.client;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class PaymentServiceClient {

    private final RestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8081/api/factures";

    public List<Map<String, Object>> getCurrentFactures(String walletCode) {

        return restTemplate.exchange(
                BASE_URL + "/" + walletCode + "/current",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Map<String, Object>>>() {
                }
        ).getBody();

    }

    public List<Map<String, Object>> getCurrentFacturesByService(
            String walletCode,
            String unite) {

        return restTemplate.exchange(
                BASE_URL + "/" + walletCode + "/current?unite=" + unite,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Map<String, Object>>>() {
                }
        ).getBody();

    }

    public List<Map<String, Object>> getFacturesByPeriod(
            String walletCode,
            String debut,
            String fin) {

        return restTemplate.exchange(
                BASE_URL + "/" + walletCode
                        + "/periode?debut=" + debut
                        + "&fin=" + fin,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Map<String, Object>>>() {
                }
        ).getBody();

    }

}
