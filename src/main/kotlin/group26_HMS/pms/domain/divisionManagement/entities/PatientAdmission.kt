package group26_HMS.pms.domain.divisionManagement.entities

import java.util.Date
import java.util.UUID

class PatientAdmission (
    val id:UUID,
    var localDoctor:String,
    var roomNumber: Number,
    var bedNumber: Number,
    var division:String,
    var patientId:String,
    val startDate: Date,
    var insuranceNumber: Number? = null,
    var status:String? = "active",
    var endDate:Date? = null
) {

    fun discharge(): Boolean {
        status = "inactive"
        endDate = Date()
        return true
    }
}