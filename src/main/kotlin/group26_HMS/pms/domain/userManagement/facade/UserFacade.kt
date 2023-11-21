package group26_HMS.pms.domain.userManagement.facade

import group26_HMS.pms.application.dtos.queries.StaffRegisterDto
import java.util.*

interface UserFacade { 
    fun registerStaff(staffInfo:StaffRegisterDto): UUID
    fun doctorExists(staffId: UUID): Boolean
}