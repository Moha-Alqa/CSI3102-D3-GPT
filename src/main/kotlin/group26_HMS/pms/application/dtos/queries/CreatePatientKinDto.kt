package group26_HMS.pms.application.dtos.queries

data class CreatePatientKinDto(
    val fullName:String,
    val relationship: String,
    var address: CreateAddressDto,
    val phoneNum: String
)