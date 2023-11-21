package group26_HMS.pms.domain.patientManagement.facade.implementation


import group26_HMS.pms.application.dtos.queries.CreatePatientDto
import group26_HMS.pms.application.services.DomainEventEmitter
import group26_HMS.pms.domain.patientManagement.events.PatientCreated
import group26_HMS.pms.domain.patientManagement.events.PatientUpdated
import group26_HMS.pms.domain.patientManagement.facade.PatientFacade
import group26_HMS.pms.domain.patientManagement.factories.PatientFactory
import group26_HMS.pms.domain.patientManagement.repositories.PatientRepository
import group26_HMS.pms.domain.prescriptionManagement.entities.Prescription
import group26_HMS.pms.domain.prescriptionManagement.events.PrescriptionCreated
import java.util.*

class PatientFacadeImpl (
    private var patientFactory: PatientFactory,
    private var patientRepository: PatientRepository,
    private var eventEmitter: DomainEventEmitter): PatientFacade {

    override fun createPatient(patientInfo: CreatePatientDto): UUID {
        val patient = patientFactory.createPatient(patientInfo)
        patientRepository.save(patient)
        eventEmitter.emit(PatientCreated(
            UUID.randomUUID(),
            Date(),
            patient.id.toString()))
        return patient.id
    }

    override fun updatePatient(patientId: String, patientInfo: CreatePatientDto): Boolean {
        val patient = patientRepository.find(patientId)
        if (patient!=null) {
            val updated = patientFactory.createPatient(patientInfo)
            patient.update(updated)
            patientRepository.save(patient)
            eventEmitter.emit(PatientUpdated(
                UUID.randomUUID(),
                Date(),
                patientId
            ))
            return true
        }
        return false
    }

    override fun addPrescription(prescriptionId: UUID, patientId:UUID): Boolean{
        val patient = patientRepository.find(patientId.toString())
        if (patient!=null) {
            patient.addPrescription(prescriptionId)
            patientRepository.save(patient)
            eventEmitter.emit(PatientUpdated(
                UUID.randomUUID(),
                Date(),
                patientId.toString()
            ))
            return true
        }
        return false
    }

    override fun patientExist(patientId: UUID):Boolean{
        val patient = patientRepository.find(patientId.toString())
        if(patient!=null)
            return true;

        return false;
    }
}