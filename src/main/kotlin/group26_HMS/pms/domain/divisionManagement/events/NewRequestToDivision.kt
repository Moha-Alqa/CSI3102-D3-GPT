package group26_HMS.pms.domain.divisionManagement.events

import group26_HMS.pms.domain.common.DomainEvent
import java.util.Date
import java.util.UUID

class NewRequestToDivision(
    val id:UUID,
    val occuredOn:Date,
    val division:String,
    val patientId:String,
    val requestId:String): DomainEvent{
}