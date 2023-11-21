package group26_HMS.pms.domain.prescriptionManagement.factories

import group26_HMS.pms.application.dtos.queries.MedicationPrescriptionDto
import group26_HMS.pms.domain.prescriptionManagement.entities.Prescription

interface PrescriptionFactory {
    fun createPrescription(prescriptionInfo:MedicationPrescriptionDto):Prescription
}