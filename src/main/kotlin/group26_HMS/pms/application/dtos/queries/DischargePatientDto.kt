package group26_HMS.pms.application.dtos.queries

import java.time.LocalDateTime
import java.util.UUID

data class DischargePatientDto(
    val chargeNurseId: UUID,
    val patientId: UUID,
    val division: String,
    val bedId: UUID,
    val dischargeDate: LocalDateTime
)
