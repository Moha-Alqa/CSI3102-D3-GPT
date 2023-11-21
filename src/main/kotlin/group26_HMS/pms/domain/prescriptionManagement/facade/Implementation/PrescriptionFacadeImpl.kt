package group26_HMS.pms.domain.prescriptionManagement.facade.implementation

import group26_HMS.pms.application.dtos.queries.MedicationPrescriptionDto
import group26_HMS.pms.application.services.DomainEventEmitter
import group26_HMS.pms.domain.prescriptionManagement.events.PrescriptionCreated
import group26_HMS.pms.domain.prescriptionManagement.facade.PrescriptionFacade
import group26_HMS.pms.domain.prescriptionManagement.factories.PrescriptionFactory
import group26_HMS.pms.domain.prescriptionManagement.repositories.PrescriptionRepository
import java.util.Date
import java.util.UUID
class PrescriptionFacadeImp(
    private var prescriptionFactory: PrescriptionFactory,
    private var prescriptionRepository: PrescriptionRepository,
    private var eventEmitter: DomainEventEmitter
):PrescriptionFacade{

    override fun createPrescription(prescriptionInfo: MedicationPrescriptionDto): Boolean {
        val prescription = prescriptionFactory.createPrescription(prescriptionInfo)
        val checkPrescription = prescriptionRepository.find(prescriptionInfo.prescriptionId)

        if(checkPrescription == null){
            prescriptionRepository.save(prescription)
            eventEmitter.emit(PrescriptionCreated(
                UUID.randomUUID(),
                Date(),
                prescription.doctorId.toString(),
                prescription.patientId.toString(),
                prescription.prescriptionId.toString()
            ))
            return true
        }
        return false
    }
}