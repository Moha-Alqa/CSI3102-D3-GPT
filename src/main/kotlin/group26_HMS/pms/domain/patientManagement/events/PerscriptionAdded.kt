package group26_HMS.pms.domain.patientManagement.events

import group26_HMS.pms.domain.common.DomainEvent
import java.util.Date
import java.util.UUID

class PerscriptionAdded(
    val id:UUID,
    val dateCreated: Date,
    val patientId:UUID,
    val perscriptionId: UUID): DomainEvent {
}