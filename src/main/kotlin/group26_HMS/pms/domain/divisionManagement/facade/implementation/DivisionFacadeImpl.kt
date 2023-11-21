package group26_HMS.pms.domain.divisionManagement.facade.implementation

import group26_HMS.pms.application.dtos.queries.AdmitPatientDto
import group26_HMS.pms.application.dtos.queries.DischargePatientDto
import group26_HMS.pms.application.dtos.queries.PatientAdmissionFromRequestListDto
import group26_HMS.pms.application.dtos.queries.PatientAdmissionRequestDto
import group26_HMS.pms.application.services.DomainEventEmitter
import group26_HMS.pms.domain.divisionManagement.events.DischargedPatientFromDivision
import group26_HMS.pms.domain.divisionManagement.events.NewAdmissionToDivision
import group26_HMS.pms.domain.divisionManagement.events.NewRequestToDivision
import group26_HMS.pms.domain.divisionManagement.events.ChangeRequestStatus
import group26_HMS.pms.domain.divisionManagement.facade.DivisionFacade
import group26_HMS.pms.domain.divisionManagement.factories.AdmissionFactory
import group26_HMS.pms.domain.divisionManagement.factories.AdmissionRequestFactory
import group26_HMS.pms.domain.divisionManagement.repositories.AdmissionRepository
import group26_HMS.pms.domain.divisionManagement.repositories.AdmissionRequestRepository
import group26_HMS.pms.domain.divisionManagement.repositories.DivisionRepository
import java.util.Date
import java.util.UUID

class DivisionFacadeImpl(
    private var admissionFactory:AdmissionFactory,
    private var admissionRequestFactory: AdmissionRequestFactory,
    private var admissionRepository: AdmissionRepository,
    private var admissionRequestRepository: AdmissionRequestRepository,
    private var divisionRepository: DivisionRepository,
    private var eventEmitter: DomainEventEmitter):DivisionFacade {

    override fun admitPatient(admitInfo: AdmitPatientDto): UUID? {
        val admission = admissionFactory.createAdmission(admitInfo)
        val division = divisionRepository.find(admitInfo.division)

        if (division!=null && division.bedIsAvailable(admitInfo.bedNumber)) {
            admissionRepository.save(admission)
            division.updateFromAdmission(admission)
            divisionRepository.save(division)
            eventEmitter.emit(NewAdmissionToDivision(
                UUID.randomUUID(),
                Date(),
                division.id,
                admitInfo.patientId.toString(),
                admission.id.toString()
            ))
            return admission.id
        }
        return null
    }

    override fun divisionIsAvailable(divisionId: String): Boolean {
        val division = divisionRepository.find(divisionId)
        if (division!=null) {
            return !division.isComplete()
        }
        return false
    }

    override fun dischargePatient(dischargeInfo: DischargePatientDto): Boolean {
        val admission = admissionRepository.find(dischargeInfo.patientId)
        val division = divisionRepository.find(dischargeInfo.division)

        if (admission!=null && division!=null) {
            division.updateFromDischarge(admission)
            divisionRepository.save(division)
            admission.discharge()
            admissionRepository.save(admission)
            eventEmitter.emit(DischargedPatientFromDivision(
                UUID.randomUUID(),
                Date(),
                division.id,
                dischargeInfo.patientId.toString(),
                admission.id.toString()
            ))
            return true
        }
        return false
    }

    override fun createRequest(requestInfo:PatientAdmissionRequestDto): UUID?{
         val request = admissionRequestFactory.createAdmissionRequest(requestInfo)
         val division = divisionRepository.find(requestInfo.division)

         if (division!=null) {
            admissionRequestRepository.save(request)
            division.addAdmissionRequest(request)
            divisionRepository.save(division)
            eventEmitter.emit(NewRequestToDivision(
                UUID.randomUUID(),
                Date(),
                division.id,
                requestInfo.patientId.toString(),
                request.id.toString()
            )
            )
            return request.id
        }
        return null
    }

    override fun isPatientAdmitted(patientId: UUID, divisionId: String): Boolean {
        val division = divisionRepository.find(divisionId)
        return division!!.isPatientAdmitted(patientId)
    }

    override fun isPatientInRequestList(patientId: UUID, divisionId: String): Boolean {
        val division = divisionRepository.find(divisionId)
        return division!!.isPatientInRequestList(patientId)
    }

    override fun acceptRequest(requestInfo: PatientAdmissionFromRequestListDto): Boolean{
        val request = admissionRequestRepository.find(requestInfo.patientId) ?: return false
        request.statusToAccept()
        admissionRequestRepository.save(request)

        val division = divisionRepository.find(requestInfo.division.toString()) ?: return false
        division.removePendingAdmissionRequest(requestInfo.patientId)
        divisionRepository.save(division)

        eventEmitter.emit(ChangeRequestStatus(
                UUID.randomUUID(),
                Date(),
                division.id,
                requestInfo.patientId.toString(),
                request.id.toString(),
                request.status
            ))

        return true
    }

    override fun denyRequest(requestInfo: PatientAdmissionFromRequestListDto): Boolean{
        val request = admissionRequestRepository.find(requestInfo.patientId) ?: return false
        request.statusToDeny()
        admissionRequestRepository.save(request)

        val division = divisionRepository.find(requestInfo.division.toString()) ?: return false
        division.removePendingAdmissionRequest(requestInfo.patientId)
        divisionRepository.save(division)

         eventEmitter.emit(ChangeRequestStatus(
                UUID.randomUUID(),
                Date(),
                division.id,
                requestInfo.patientId.toString(),
                request.id.toString(),
                request.status
            ))

        return true
    }
}