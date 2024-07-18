package uz.axonlogic.octobank.api

import uz.axonlogic.octobank.api.id.OctoBankId
import java.math.BigDecimal

//data class CreateOctoBankEvent(
//    val octoBankId: String,
//
//    val orderId: String,
//    var paymentId: String,
//    var userId: String,
//    var expressIds: String,
//    val totalCost: BigDecimal,
//)

data class ConfirmPaymentEvent (
    val octoBankId: OctoBankId,
    val octo_shop_id: Int,
    val octo_secret: String,
    val octo_payment_UUID: String,
    val accept_status: String
)

data class ConfirmPaymentSuccededEvent (
    val octoBankId: OctoBankId,
    var response: Any
)

data class ConfirmPaymentFailedEvent (
    val octoBankId: OctoBankId,
    var response: Any
)