package group26_HMS.pms.application.usecases.implementation

import group26_HMS.pms.application.dtos.queries.CreatePatientDto
import group26_HMS.pms.application.usecases.UpdatePatientFile
import group26_HMS.pms.domain.patientManagement.facade.PatientFacade
import java.util.*

class UpdatePatientFileImpl(
    private var patientFacade:PatientFacade):UpdatePatientFile {
    override fun updatePatientFile(patientId: UUID, patientInfo: CreatePatientDto): Boolean {
        return patientFacade.updatePatient(patientId.toString(), patientInfo)
    }

    // Currently not used so not implemented, we left incase needed for D3.
    override fun checkStaffPrivilege(staffId: UUID): Boolean {
        TODO("Not yet implemented")
    }
}