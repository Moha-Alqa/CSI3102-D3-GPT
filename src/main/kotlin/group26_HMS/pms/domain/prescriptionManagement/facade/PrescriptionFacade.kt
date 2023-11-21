package group26_HMS.pms.domain.prescriptionManagement.facade

import group26_HMS.pms.application.dtos.queries.MedicationPrescriptionDto

interface PrescriptionFacade {
    fun createPrescription(prescriptionInfo:MedicationPrescriptionDto):Boolean
}