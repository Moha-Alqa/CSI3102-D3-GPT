package group26_HMS.pms.domain.prescriptionManagement.events

import group26_HMS.pms.domain.common.DomainEvent
import java.util.Date
import java.util.UUID

class PrescriptionCreated (
    val id:UUID,
    val dateCreated:Date,
    val doctorId:String,
    val patientId:String,
    val prescriptionId:String):DomainEvent {
}