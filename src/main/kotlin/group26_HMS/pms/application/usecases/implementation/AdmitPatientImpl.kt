package group26_HMS.pms.application.usecases.implementation

import group26_HMS.pms.application.dtos.queries.AdmitPatientDto
import group26_HMS.pms.application.usecases.AdmitPatient
import group26_HMS.pms.domain.divisionManagement.facade.DivisionFacade
import java.util.*

class AdmitPatientImpl(
    private var divisionFacade: DivisionFacade): AdmitPatient{
    override fun admitPatient(admitInfo: AdmitPatientDto, chargeNurseId: UUID): UUID? {
        if (divisionFacade.divisionIsAvailable(admitInfo.division)) {
            return divisionFacade.admitPatient(admitInfo)
        }
        return null
    }
}