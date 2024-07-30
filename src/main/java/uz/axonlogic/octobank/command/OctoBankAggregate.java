package uz.axonlogic.octobank.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import uz.axonlogic.octobank.api.*;
import uz.axonlogic.octobank.api.id.OctoBankId;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class OctoBankAggregate  {

    @AggregateIdentifier
    private OctoBankId id;
    private Integer idError;

    public OctoBankAggregate ( ) { }

    @CommandHandler
    public OctoBankAggregate ( ConfirmPaymentCommand command ) {
        System.out.println ( " ConfirmPaymentCommand KELDI :" + command );
        apply ( new ConfirmPaymentEvent ( command.getOctoBankId(), command.getOcto_shop_id(), command.getOcto_secret(), command.getOcto_payment_UUID(), command.getAccept_status() ));
        System.out.println (" -> ConfirmPaymentEvent jo'natildi :" + command );
    }

    @EventSourcingHandler
    public void on ( ConfirmPaymentEvent event) {
        System.out.println("agreggateda->" + event);
        this.id = event.getOctoBankId();
    }

    @CommandHandler
    public void handle ( SetConfirmPaymeCommand command) {
        System.out.println("SetConfirmPaymeCommand keldi: " + command );
        System.out.println("this.id:" + this.id);
        System.out.println("command.getResponse().getError():" + command.getResponse().getError());

        if ( command.getResponse().getError() == 0 )  {
            apply (new ConfirmPaymentSuccededEvent( command.getOctoBankId(), command.getResponse()));
        } else  if (command.getResponse().getError() == 2)  {
            apply (new ConfirmPaymentFailedEvent( command.getOctoBankId(), command.getResponse(), command.getResponse().getError() ));
        }
    }

    @EventSourcingHandler
    public void on ( ConfirmPaymentSuccededEvent event) {

    }

    @EventSourcingHandler
    public void on ( ConfirmPaymentFailedEvent event ) {
        this.idError = event.getIdError();
    }

    @CommandHandler
    public void handle( AdditionalCommand command ){
        System.out.println("AdditionalCommand KELDI:" + command);
        apply (new AdditionalEvent (command.getOctoBankId(), command.getIdError() ));
    }

    @EventSourcingHandler
    public void handle (AdditionalEvent event){ }
}