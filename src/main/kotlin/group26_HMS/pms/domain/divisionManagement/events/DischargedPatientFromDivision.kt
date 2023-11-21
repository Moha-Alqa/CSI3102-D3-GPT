package group26_HMS.pms.domain.divisionManagement.events

import group26_HMS.pms.domain.common.DomainEvent
import java.util.Date
import java.util.UUID

class DischargedPatientFromDivision(
    val id:UUID,
    val occuredOn:Date,
    val division:String,
    val patient:String,
    val admissionId:String):DomainEvent {
}