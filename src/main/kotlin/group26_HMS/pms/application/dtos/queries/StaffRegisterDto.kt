package group26_HMS.pms.application.dtos.queries

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

data class StaffRegisterDto(
    val staffFName: String,
    val staffLName: String,
    val employeeId: UUID, //user identification/employee number
    val password: String,
    val contactEmail: String,
    val contactPhone: String
)