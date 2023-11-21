package group26_HMS.pms.contracts.testStubs.repositories

import group26_HMS.pms.domain.patientManagement.entities.Patient
import group26_HMS.pms.domain.patientManagement.repositories.PatientRepository

class PatientRepositoryStub: PatientRepository {
    private val patients: MutableMap<String, Patient> = HashMap()

    override fun find(patientId: String): Patient? = patients[patientId]

    override fun save(patient: Patient): Patient {
        patients[patient.id.toString()] = patient
        return patient
    }
}