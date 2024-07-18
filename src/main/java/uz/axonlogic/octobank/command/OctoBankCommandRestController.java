package uz.axonlogic.octobank.command;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import uz.axonlogic.octobank.api.ConfirmPaymentCommand;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/octobank")
public class OctoBankCommandRestController {

    private final CommandGateway commandGateway;

    @Autowired
    public OctoBankCommandRestController( CommandGateway commandGateway){
        this.commandGateway=commandGateway;
    }

//    @PostMapping(path = "/webhooks")
//    public Mono<ResponseEntity <?> > webhooks(@RequestBody String payload) {
//        log.info ("Come" + payload);
//        return Mono.just (ResponseEntity.status(HttpStatus.OK).build() );
//    }

    @PostMapping(path = "/confirm")
    public void confirmPayment ( @RequestBody ConfirmPaymentCommand command){
      log.info("Comfirm payment: " + command);
      commandGateway.send ( command );
    }


}