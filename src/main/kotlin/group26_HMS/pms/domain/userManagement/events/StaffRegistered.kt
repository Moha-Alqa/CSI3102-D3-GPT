package group26_HMS.pms.domain.userManagement.events

import group26_HMS.pms.domain.common.DomainEvent
import java.util.Date
import java.util.UUID

class StaffRegistered (
    val id:UUID,
    val registeredDate:Date,
    val staffId:String):DomainEvent {
}