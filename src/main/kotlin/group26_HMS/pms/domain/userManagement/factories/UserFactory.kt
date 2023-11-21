package group26_HMS.pms.domain.userManagement.factories

import group26_HMS.pms.application.dtos.queries.StaffRegisterDto
import group26_HMS.pms.domain.userManagement.entities.Staff

interface UserFactory {
    fun createStaff(staffInfo:StaffRegisterDto): Staff
}