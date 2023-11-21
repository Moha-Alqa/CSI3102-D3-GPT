package group26_HMS.pms.application.usecases.implementation

import group26_HMS.pms.application.dtos.queries.AdmitPatientDto
import group26_HMS.pms.application.dtos.queries.PatientAdmissionFromRequestListDto
import group26_HMS.pms.application.usecases.AdmitPatientFromRequestList
import group26_HMS.pms.domain.divisionManagement.facade.DivisionFacade
import java.util.*

class AdmitPatientFromRequestListImpl (
    private var divisionFacade: DivisionFacade,
    private var admitPatientImpl: AdmitPatientImpl
):AdmitPatientFromRequestList{

    override fun admitFromRequest(requestInfo: PatientAdmissionFromRequestListDto): UUID? {

        // Admit the patient
        divisionFacade.acceptRequest(requestInfo)

        val admitPatientDto = AdmitPatientDto(
            localDoctor = requestInfo.localDoctor,
            division = requestInfo.division.toString(),
            roomNumber = requestInfo.roomNumber,
            bedNumber = requestInfo.bedNumber,
            patientId = requestInfo.patientId
        )

        return admitPatientImpl.admitPatient(admitPatientDto,requestInfo.chargeNurseId)
    }

    override fun denyRequest(requestInfo: PatientAdmissionFromRequestListDto): Boolean {
        return divisionFacade.denyRequest(requestInfo)
    }
}