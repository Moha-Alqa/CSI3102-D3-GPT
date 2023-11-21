package group26_HMS.pms.contracts.testStubs.factories

import group26_HMS.pms.application.dtos.queries.PatientAdmissionRequestDto
import group26_HMS.pms.domain.divisionManagement.entities.AdmissionRequest
import group26_HMS.pms.domain.divisionManagement.factories.AdmissionRequestFactory
import java.util.*

class AdmissionRequestFactoryStub:AdmissionRequestFactory {
    override fun createAdmissionRequest(requestInfo: PatientAdmissionRequestDto): AdmissionRequest {
        return AdmissionRequest(
            UUID.randomUUID(),
            requestInfo.patientId,
            requestInfo.rationale,
            requestInfo.priority,
            requestInfo.localDoctor,
            requestInfo.division,
            requestInfo.localDoctor
        )
    }
}