package group26_HMS.pms.domain.patientManagement.events

import group26_HMS.pms.domain.common.DomainEvent
import java.util.Date
import java.util.UUID

class PatientCreated(
    val id:UUID,
    val dateCreated: Date,
    val patientId:String): DomainEvent {
}