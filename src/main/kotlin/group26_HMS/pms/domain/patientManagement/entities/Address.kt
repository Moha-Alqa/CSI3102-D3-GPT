package group26_HMS.pms.domain.patientManagement.entities

class Address (
    val streetNumber:Number,
    val streetName:String,
    val city: String,
    val state:String,
    val country:String,
    val postalCode:String,
    var unitNumber: Number? = null
) {
}