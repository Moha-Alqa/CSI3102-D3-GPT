package group26_HMS.pms.domain.patientManagement.repositories

import group26_HMS.pms.domain.patientManagement.entities.Patient

interface PatientRepository {
    fun find(patientId: String): Patient?
    fun save(patient:Patient): Patient
}