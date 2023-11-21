package group26_HMS.pms.domain.userManagement.entities

import java.util.UUID

class Staff(
    val staffId: UUID,
    var staffFName: String,
    var staffLName: String,
    var password: String,
    var contactEmail: String,
    var contactPhone: String,
    var position: StaffPosition
){
    fun update(updated: Staff) {
        staffFName = updated.staffFName
        staffLName = updated.staffLName
        password = updated.password
        contactEmail = updated.contactEmail
        contactPhone = updated.contactPhone
        position = updated.position
    }
}