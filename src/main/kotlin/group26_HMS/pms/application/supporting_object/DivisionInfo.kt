package group26_HMS.pms.application.supporting_object

import java.util.UUID

data class DivisionInfo (
    val divisionId: UUID,
    val name:String,
    val chargeNurse: ChargeNurseInfo,
    val location: String,
    val phoneNumber: String,
    val numOfBeds: Number,
    val status: String,
)