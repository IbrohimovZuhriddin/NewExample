package uz.axonlogic.octobank.api

import org.axonframework.modelling.command.TargetAggregateIdentifier
import uz.axonlogic.octobank.api.id.OctoBankId
import uz.axonlogic.octobank.api.vObject.ConfirmPaymentResponse

abstract class OctobankCommand ( @TargetAggregateIdentifier open val octoBankId: OctoBankId)

data class ConfirmPaymentCommand (
    override val octoBankId: OctoBankId = OctoBankId(),
    val octo_shop_id: Int,
    val octo_secret: String,
    val octo_payment_UUID: String,
    val accept_status: String
) : OctobankCommand ( octoBankId )

data class SetConfirmPaymeCommand(
    override val octoBankId: OctoBankId,
    val response: ConfirmPaymentResponse
) : OctobankCommand ( octoBankId )

data class LetS (
  override val octoBankId: OctoBankId
) : OctobankCommand ( octoBankId )

data class AdditionalCommand (
   override val octoBankId: OctoBankId,
    val idError :Int
): OctobankCommand ( octoBankId )