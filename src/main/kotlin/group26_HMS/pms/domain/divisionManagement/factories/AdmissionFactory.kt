package group26_HMS.pms.domain.divisionManagement.factories

import group26_HMS.pms.application.dtos.queries.AdmitPatientDto
import group26_HMS.pms.application.dtos.queries.PatientAdmissionRequestDto
import group26_HMS.pms.domain.divisionManagement.entities.AdmissionRequest
import group26_HMS.pms.domain.divisionManagement.entities.PatientAdmission

interface AdmissionFactory {
    fun createAdmission(admitInfo:AdmitPatientDto):PatientAdmission
}