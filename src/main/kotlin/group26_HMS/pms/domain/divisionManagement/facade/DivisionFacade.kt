package group26_HMS.pms.domain.divisionManagement.facade

import group26_HMS.pms.application.dtos.queries.AdmitPatientDto
import group26_HMS.pms.application.dtos.queries.DischargePatientDto
import group26_HMS.pms.application.dtos.queries.PatientAdmissionFromRequestListDto
import group26_HMS.pms.application.dtos.queries.PatientAdmissionRequestDto
import group26_HMS.pms.domain.divisionManagement.entities.AdmissionRequest
import group26_HMS.pms.domain.divisionManagement.entities.PatientAdmission
import java.util.UUID

interface DivisionFacade {
    fun admitPatient(admitInfo:AdmitPatientDto): UUID?
    fun divisionIsAvailable(divisionId:String): Boolean
    fun dischargePatient(dischargeInfo:DischargePatientDto): Boolean
    fun createRequest(requestInfo: PatientAdmissionRequestDto): UUID?
    fun isPatientAdmitted(patientId:UUID, divisionId:String):Boolean
    fun isPatientInRequestList(patientId:UUID, divisionId: String):Boolean
    fun acceptRequest(requestInfo: PatientAdmissionFromRequestListDto): Boolean
    fun denyRequest(requestInfo: PatientAdmissionFromRequestListDto):Boolean
}