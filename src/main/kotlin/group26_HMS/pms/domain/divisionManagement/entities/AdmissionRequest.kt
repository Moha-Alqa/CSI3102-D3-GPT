package group26_HMS.pms.domain.divisionManagement.entities

import java.util.UUID

class AdmissionRequest (
    val id:UUID,
    val patientId:UUID,
    var rationale:String,
    var priority:Number,
    var localDoctor:String,
    var divisionId:String,
    var status: String = "Pending" // New field to track request status
) {
    // Update the status of the admission request
    fun updateStatus(newStatus: String) {
        status = newStatus
    }

    // Method to represent the request as a string (useful for logging or debugging)
    override fun toString(): String {
        return "AdmissionRequest(id=$id, patientId=$patientId, divisionId=$divisionId, rationale='$rationale', priority=$priority, localDoctor='$localDoctor', status='$status')"
    }

    fun statusToAccept(){
        status = "Accept"
    }

    fun statusToDeny(){
        status = "Deny"
    }
}