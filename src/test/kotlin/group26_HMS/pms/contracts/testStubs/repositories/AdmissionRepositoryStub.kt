package group26_HMS.pms.contracts.testStubs.repositories

import group26_HMS.pms.domain.divisionManagement.entities.PatientAdmission
import group26_HMS.pms.domain.divisionManagement.repositories.AdmissionRepository
import java.util.*

class AdmissionRepositoryStub:AdmissionRepository {
    private val admissions: MutableMap<String, PatientAdmission> = HashMap()

    override fun find(patientId: UUID): PatientAdmission? {
        admissions.forEach{ (_, admission) ->
            if (admission.patientId == patientId.toString()) {
                return admission
            }
        }
        return null
    }

    override fun save(admission: PatientAdmission): PatientAdmission {
        admissions[admission.id.toString()] = admission
        return admission
    }
}