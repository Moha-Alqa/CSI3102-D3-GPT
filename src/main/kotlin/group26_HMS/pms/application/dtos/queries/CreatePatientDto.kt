package group26_HMS.pms.application.dtos.queries

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

data class CreatePatientDto (
    val staffId: UUID,
    val firstName:String,
    val lastName:String,
    val insuranceNum: Number,
    var address:CreateAddressDto,
    val email:String,
    val phoneNumber:String,
    val dateOfBirth:LocalDate,
    val gender: String,
    val maritalStatus: String,
    val externalDoctor: String,
    var nextOfKin: CreatePatientKinDto
)