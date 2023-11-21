package group26_HMS.pms.application.dtos.queries

import java.time.LocalDateTime
import java.util.UUID

data class PatientAdmissionRequestDto(
    val chargeNurseId: UUID,
    val patientId: UUID,
    val division: String,
    val rationale: String,
    val priority: Number,
    val localDoctor: String,
    val requestDate: LocalDateTime
)
