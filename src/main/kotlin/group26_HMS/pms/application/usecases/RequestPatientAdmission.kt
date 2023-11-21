package group26_HMS.pms.application.usecases

import group26_HMS.pms.application.dtos.queries.PatientAdmissionRequestDto
import java.util.UUID

interface RequestPatientAdmission {
    fun requestPatientAdmission(requestInfo: PatientAdmissionRequestDto): UUID?
}
