package group26_HMS.pms.domain.divisionManagement.repositories

import group26_HMS.pms.domain.divisionManagement.entities.Division
import group26_HMS.pms.domain.divisionManagement.entities.PatientAdmission
import java.util.*

interface AdmissionRepository {
    fun find(patientId: UUID):PatientAdmission?
    fun save(admission:PatientAdmission):PatientAdmission
}