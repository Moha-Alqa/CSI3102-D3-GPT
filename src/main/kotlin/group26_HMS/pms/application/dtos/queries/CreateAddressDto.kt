package group26_HMS.pms.application.dtos.queries

data class CreateAddressDto(
    val streetNumber: Number,
    val streetName: String,
    val city: String,
    val country: String,
    val state: String,
    val postalCode: String,
    val unitNumber: Number? = null,
)
