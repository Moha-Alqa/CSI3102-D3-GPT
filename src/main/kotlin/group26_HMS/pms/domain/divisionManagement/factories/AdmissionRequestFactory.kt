package group26_HMS.pms.domain.divisionManagement.factories

import group26_HMS.pms.application.dtos.queries.PatientAdmissionRequestDto
import group26_HMS.pms.domain.divisionManagement.entities.AdmissionRequest

interface AdmissionRequestFactory {
    fun createAdmissionRequest(requestInfo: PatientAdmissionRequestDto): AdmissionRequest
}