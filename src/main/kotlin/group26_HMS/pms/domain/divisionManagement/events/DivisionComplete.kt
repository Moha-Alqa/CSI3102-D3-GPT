package group26_HMS.pms.domain.divisionManagement.events

import group26_HMS.pms.domain.common.DomainEvent
import java.util.Date
import java.util.UUID

class DivisionComplete(
    val id:UUID,
    val occuredOn:Date,
    val division:String,
    var chargeNurseId: UUID,
    val admissionId:String): DomainEvent{
}