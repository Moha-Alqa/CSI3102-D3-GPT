package group26_HMS.pms.domain.userManagement.entities

import java.util.*

class StaffPosition(
    val position: Position,
    val division:String
){
}

enum class Position {
    DOCTOR,
    CHARGE_NURSE,
    MEDICAL_STAFF
}