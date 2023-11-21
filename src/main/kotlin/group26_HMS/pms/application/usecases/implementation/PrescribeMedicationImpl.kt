
package group26_HMS.pms.application.usecases.implementation

import group26_HMS.pms.application.dtos.queries.MedicationPrescriptionDto
import group26_HMS.pms.application.usecases.PrescribeMedication
import group26_HMS.pms.domain.prescriptionManagement.facade.PrescriptionFacade


class PrescribeMedicationImpl(
    private var prescriptionFacade: PrescriptionFacade
): PrescribeMedication{
    override fun prescribeMedication(prescriptionInfo: MedicationPrescriptionDto): Boolean {
        return prescriptionFacade.createPrescription(prescriptionInfo)
    }
}