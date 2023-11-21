package group26_HMS.pms.application.usecases

import group26_HMS.pms.application.dtos.queries.DischargePatientDto
import java.util.UUID

interface DischargePatient {
    fun dischargePatient(patientDischarge: DischargePatientDto): Boolean
    fun printDischargeInformation(patientId: UUID): String
}