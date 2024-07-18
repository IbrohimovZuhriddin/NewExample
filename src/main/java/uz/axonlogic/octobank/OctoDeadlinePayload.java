package uz.axonlogic.octobank;


import lombok.AllArgsConstructor;
import lombok.Data;
import uz.axonlogic.octobank.api.id.OctoBankId;

@Data
@AllArgsConstructor
public class OctoDeadlinePayload {

    private final OctoBankId id;



}
