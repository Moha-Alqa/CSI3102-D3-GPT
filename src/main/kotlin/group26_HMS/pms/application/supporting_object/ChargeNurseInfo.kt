package group26_HMS.pms.application.supporting_object

import java.util.UUID

data class ChargeNurseInfo(
    val staffId: UUID,
    val name:String,
    val phoneExtension:String,
    val bipperExtension:String
)
