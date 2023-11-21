package group26_HMS.pms.application.usecases.implementation

import group26_HMS.pms.application.dtos.queries.PatientAdmissionRequestDto
import group26_HMS.pms.application.usecases.RequestPatientAdmission
import group26_HMS.pms.domain.divisionManagement.facade.DivisionFacade
import group26_HMS.pms.domain.patientManagement.facade.PatientFacade
import java.util.UUID

class RequestPatientAdmissionImpl(
    private val patientFacade: PatientFacade,
    private val divisionFacade: DivisionFacade
) : RequestPatientAdmission {

    override fun requestPatientAdmission(requestInfo: PatientAdmissionRequestDto): UUID? {
        val patientId = requestInfo.patientId
        val divisionId = requestInfo.division
        val exists = patientFacade.patientExist(patientId)
        val admitted = divisionFacade.isPatientAdmitted(patientId, divisionId)
        val inList = divisionFacade.isPatientInRequestList(patientId, divisionId)

        if (exists && !admitted && !inList) {
            return divisionFacade.createRequest(requestInfo)
        }
        return null
    }
}
