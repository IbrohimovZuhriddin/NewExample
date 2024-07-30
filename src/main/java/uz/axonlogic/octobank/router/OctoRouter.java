package uz.axonlogic.octobank.router;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.axonlogic.octobank.api.*;
import uz.axonlogic.octobank.api.vObject.ConfirmPaymentResponse;
import uz.axonlogic.octobank.service.OctoService;

@Component
public class OctoRouter {

    @Autowired
    private OctoService service;

    @Autowired
    private CommandGateway commandGateway;

    @EventHandler
    public void handle ( ConfirmPaymentEvent event ) {
        // agar response umuman kelmasa
        System.out.println ("ConfirmPaymentEvent keldi sagaga :" + event);
        ConfirmPaymentResponse response = service.sendToOctoRes (event);
        System.out.println(response);
        System.out.println("event.getOctoBankId()" + event.getOctoBankId() );
        commandGateway.send ( new SetConfirmPaymeCommand ( event.getOctoBankId(), response ) );
    }

    @EventHandler
    public void handle (ConfirmPaymentFailedEvent event) {
        System.out.println("ConfirmPaymentFailedEvent keldi sagaga :" + event);
        commandGateway.send( new AdditionalCommand(event.getOctoBankId(),event.getIdError() ) );
    }

}