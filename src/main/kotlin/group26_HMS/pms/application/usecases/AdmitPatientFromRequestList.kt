package group26_HMS.pms.application.usecases

import group26_HMS.pms.application.dtos.queries.PatientAdmissionFromRequestListDto
import java.util.UUID

interface AdmitPatientFromRequestList {
    fun admitFromRequest(requestInfo: PatientAdmissionFromRequestListDto): UUID?
    fun denyRequest(requestInfo: PatientAdmissionFromRequestListDto): Boolean
}
