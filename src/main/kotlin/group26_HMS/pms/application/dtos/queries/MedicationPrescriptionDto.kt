package group26_HMS.pms.application.dtos.queries

import java.time.LocalDateTime
import java.util.UUID

data class MedicationPrescriptionDto(
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
)
