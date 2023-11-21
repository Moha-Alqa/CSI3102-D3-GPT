package group26_HMS.pms.application.usecases.implementation

import group26_HMS.pms.application.dtos.queries.StaffRegisterDto
import group26_HMS.pms.application.usecases.RegisterStaff
import group26_HMS.pms.domain.userManagement.facade.UserFacade
import java.util.*

class RegisterStaffImpl(
    private var userFacade: UserFacade):RegisterStaff {
    override fun addStaff(staffInfo: StaffRegisterDto): UUID {
        return userFacade.registerStaff(staffInfo)
    }

    // Currently not used so not implemented, we left incase needed for D3.
    override fun findUserInSystem(staffId: UUID): Boolean {
        TODO("Not yet implemented")
    }
}