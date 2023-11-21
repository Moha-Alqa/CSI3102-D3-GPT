package group26_HMS.pms.application.usecases

import group26_HMS.pms.application.dtos.queries.CreatePatientDto
import java.util.*

interface RegisterPatient {
    fun addPatient(patientInfo: CreatePatientDto): UUID
    fun checkStaffLoggedIn(staffID: UUID): Boolean
    
}