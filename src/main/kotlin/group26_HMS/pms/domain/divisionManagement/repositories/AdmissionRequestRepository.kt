package group26_HMS.pms.domain.divisionManagement.repositories

import group26_HMS.pms.domain.divisionManagement.entities.AdmissionRequest
import java.util.*

interface AdmissionRequestRepository {
    fun find(patientId: UUID): AdmissionRequest?
    fun save(request:AdmissionRequest):AdmissionRequest
}