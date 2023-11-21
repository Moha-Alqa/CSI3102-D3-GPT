package group26_HMS.pms.contracts.testStubs.factories

import group26_HMS.pms.application.dtos.queries.AdmitPatientDto
import group26_HMS.pms.application.dtos.queries.PatientAdmissionRequestDto
import group26_HMS.pms.domain.divisionManagement.entities.AdmissionRequest
import group26_HMS.pms.domain.divisionManagement.entities.PatientAdmission
import group26_HMS.pms.domain.divisionManagement.factories.AdmissionFactory
import java.util.*

class AdmissionFactoryStub:AdmissionFactory {
    override fun createAdmission(admitInfo: AdmitPatientDto): PatientAdmission {
        return PatientAdmission(
            UUID.randomUUID(),
            admitInfo.localDoctor,
            admitInfo.roomNumber,
            admitInfo.bedNumber,
            admitInfo.division,
            admitInfo.patientId.toString(),
            Date(),
            admitInfo.insuranceNum
        )
    }
}