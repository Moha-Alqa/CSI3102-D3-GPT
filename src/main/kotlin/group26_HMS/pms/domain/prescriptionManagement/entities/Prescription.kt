package group26_HMS.pms.domain.prescriptionManagement.entities

import java.time.LocalDateTime
import java.util.*

class Prescription(
    val prescriptionId: UUID,
    val doctorId: UUID,
    val patientId: UUID,
    val drugNumber: Number,
    val medicationName: String,
    val unitsByDay: String,
    val administrationPerDay: String,
    val instructions:String,
    val methodOfAdministration: String,
    val prescriptionDate: LocalDateTime,
    val startDate: LocalDateTime,
    val endDate: LocalDateTime
){
}