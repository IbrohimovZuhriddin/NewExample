package uz.axonlogic.octobank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import uz.axonlogic.octobank.api.ConfirmPaymentEvent;
import uz.axonlogic.octobank.api.vObject.ConfirmPaymentResponse;
import java.util.HashMap;
import java.util.Map;

@Service
public class OctoService {

    @Autowired
    private RestTemplate restTemplate;

    public ConfirmPaymentResponse sendToOctoRes(ConfirmPaymentEvent event) {
        String url = "https://secure.octo.uz/set_accept";

        Map<String, Object> payload = new HashMap<>();
        payload.put("octo_shop_id", event.getOcto_shop_id());
        payload.put("octo_secret", event.getOcto_secret());
        payload.put("octo_payment_UUID", event.getOcto_payment_UUID());
        payload.put("accept_status", event.getAccept_status());

        HttpEntity requestEntity = new HttpEntity<>(payload);

        ConfirmPaymentResponse response = null;

        try {
             response = restTemplate.postForObject (url, requestEntity, ConfirmPaymentResponse.class);
        } catch ( HttpServerErrorException.InternalServerError ex ) {
            ex.getMessage();
        }
        return response;
    }
}