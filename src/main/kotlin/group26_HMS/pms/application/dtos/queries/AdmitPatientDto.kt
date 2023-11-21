package group26_HMS.pms.application.dtos.queries

import java.time.LocalDateTime
import java.util.UUID

data class AdmitPatientDto(
    val localDoctor: String,
    val division: String,
    val roomNumber: Number,
    val bedNumber: Number,
    val patientId: UUID
) {
    var insuranceNum:Number? = null
}
