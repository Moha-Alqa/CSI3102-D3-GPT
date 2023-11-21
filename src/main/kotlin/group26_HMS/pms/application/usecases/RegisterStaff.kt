package group26_HMS.pms.application.usecases

import group26_HMS.pms.application.dtos.queries.StaffRegisterDto
import java.util.*

interface RegisterStaff {
    fun addStaff(staffInfo: StaffRegisterDto): UUID
    fun findUserInSystem(staffId: UUID): Boolean    
}