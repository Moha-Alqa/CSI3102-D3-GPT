package group26_HMS.pms.domain.prescriptionManagement.repositories

import group26_HMS.pms.domain.prescriptionManagement.entities.Prescription
import java.util.*

interface PrescriptionRepository {
    fun find(prescriptionId: UUID):Prescription?
    fun save(prescriptionInfo:Prescription):Prescription
}