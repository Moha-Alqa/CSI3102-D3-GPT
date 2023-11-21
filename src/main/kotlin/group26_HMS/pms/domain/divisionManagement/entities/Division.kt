package group26_HMS.pms.domain.divisionManagement.entities

import java.util.UUID

class Division(
    val id: String,
    var name: String,
    var chargeNurseId: UUID,
    var location: String,
    var totalBeds: Number,
    var phoneExt:Number,
    var status: String? = "incomplete"
) {
    private var availableBeds:MutableList<Number> = mutableListOf()
    private var admissions:MutableList<UUID> = mutableListOf() //list of patient ids
    private var pendingAdmissionRequests:MutableList<UUID> = mutableListOf() //list of patient ids

    fun isComplete():Boolean {
        return status.equals("complete")
    }

    fun updateFromAdmission(admission:PatientAdmission):Boolean {
        availableBeds.remove(admission.bedNumber)
        admissions.add(UUID.fromString(admission.patientId))
        if (availableBeds.size==totalBeds) {
            status = "complete"
        }
        return true
    }

    fun updateFromDischarge(admission:PatientAdmission):Boolean {
        availableBeds.add(admission.bedNumber)
        admissions.remove(UUID.fromString(admission.patientId))
        if (status.equals("complete")) {
            status = "incomplete"
        }
        return true;
    }

    fun setAvailableBeds(list: List<Number>) {
        list.forEach { bed ->
            availableBeds.add(bed)
        }
    }

    fun bedIsAvailable(bedNumber: Number):Boolean {
        return availableBeds.contains(bedNumber)
    }

    // New methods for admitting patient into division UC9
    fun addAdmissionRequest(request: AdmissionRequest) {
        pendingAdmissionRequests.add(request.patientId)
    }

    fun removePendingAdmissionRequest(patientId: UUID) {
        pendingAdmissionRequests.remove(patientId)
    }

    fun isPatientAdmitted(patientId: UUID):Boolean{
        return admissions.contains(patientId)
    }

    fun isPatientInRequestList(patientId: UUID): Boolean {
        return pendingAdmissionRequests.contains(patientId)
    }


}