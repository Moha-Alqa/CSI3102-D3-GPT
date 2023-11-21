package group26_HMS.pms.application.usecases.implementation

import group26_HMS.pms.application.dtos.queries.DischargePatientDto
import group26_HMS.pms.application.usecases.DischargePatient
import group26_HMS.pms.domain.divisionManagement.facade.DivisionFacade
import java.util.*

class DischargePatientImpl(
    private var divisionFacade: DivisionFacade): DischargePatient {
    override fun dischargePatient(patientDischarge: DischargePatientDto): Boolean {
        return divisionFacade.dischargePatient(patientDischarge)
    }

    // Currently not used so not implemented, we left incase needed for D3.
    override fun printDischargeInformation(patientId: UUID): String {
        TODO("Not yet implemented")
    }
}