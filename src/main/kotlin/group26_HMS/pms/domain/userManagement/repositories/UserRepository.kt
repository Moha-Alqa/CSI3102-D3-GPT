package group26_HMS.pms.domain.userManagement.repositories

import group26_HMS.pms.domain.userManagement.entities.Position
import group26_HMS.pms.domain.userManagement.entities.Staff
import java.util.*

interface UserRepository {
    fun find(staffId: UUID):Staff?
    fun save(staff:Staff):Staff
    fun getPosition(staffId: UUID): Position?
}