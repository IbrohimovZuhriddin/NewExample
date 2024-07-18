package uz.axonlogic.octobank.api.vObject;

import lombok.Data;

import java.io.Serializable;

@Data
public class ConfirmPaymentResponse implements Serializable {

    private Integer error;
    private String status;
    private String shop_transaction_id;
    private String octo_payment_UUID;
    private String octo_pay_url;
}
