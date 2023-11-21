package group26_HMS.pms.application.usecases

import group26_HMS.pms.application.dtos.queries.MedicationPrescriptionDto
import java.util.UUID

interface PrescribeMedication {
    fun prescribeMedication(prescriptionInfo: MedicationPrescriptionDto): Boolean
}
