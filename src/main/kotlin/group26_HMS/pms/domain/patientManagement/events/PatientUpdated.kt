package group26_HMS.pms.domain.patientManagement.events

import group26_HMS.pms.domain.common.DomainEvent
import java.util.Date
import java.util.UUID

class PatientUpdated(
    val id:UUID,
    val dateUpdated:Date,
    val patientId:String): DomainEvent{
}