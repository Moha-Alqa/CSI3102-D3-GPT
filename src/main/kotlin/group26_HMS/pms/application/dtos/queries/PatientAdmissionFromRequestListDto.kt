package group26_HMS.pms.application.dtos.queries

import java.time.LocalDateTime
import java.util.UUID

data class PatientAdmissionFromRequestListDto(
    val chargeNurseId: UUID,
    val patientId: UUID,
    val division: UUID,
    val admissionDate: LocalDateTime,
    val roomNumber: Number,
    val bedNumber: Number,
    val localDoctor: String
)
