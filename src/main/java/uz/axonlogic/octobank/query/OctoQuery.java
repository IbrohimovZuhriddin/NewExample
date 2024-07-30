package uz.axonlogic.octobank.query;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import uz.axonlogic.octobank.api.ConfirmPaymentFailedEvent;

@Component
public class OctoQuery {

    private OctoRepository repository;

    public OctoQuery ( OctoRepository repository){
        this.repository=repository;
    }

    @EventHandler
    public void handle(ConfirmPaymentFailedEvent event ){
        System.out.println("event.getOctoBankId() Entityda saqlaash :"+event.getOctoBankId() );
        OctoEntity entity = new OctoEntity();
        entity.setId ( event.getOctoBankId().toString());
        entity.setError ( event.getResponse().toString());
        repository.save ( entity );
    }
}