package group26_HMS.pms.contracts.testStubs.repositories

import group26_HMS.pms.domain.userManagement.entities.Position
import group26_HMS.pms.domain.userManagement.entities.Staff
import group26_HMS.pms.domain.userManagement.repositories.UserRepository
import java.util.*
import kotlin.collections.HashMap


class UserRepositoryStub:UserRepository {
    private val users: MutableMap<String, Staff> = HashMap()
    override fun find(staffId: UUID): Staff? = users[staffId.toString()]

    override fun save(staff: Staff): Staff {
        users[staff.staffId.toString()] = staff
        return staff
    }

    override fun getPosition(staffId: UUID): Position? {
        val user = find(staffId)
        if (user != null) {
            return user.position.position
        }
        return null
    }
}