package group26_HMS.pms.domain.patientManagement.facade

import group26_HMS.pms.application.dtos.queries.CreatePatientDto
import java.util.UUID

interface PatientFacade {
    fun createPatient(patientInfo: CreatePatientDto): UUID
    fun updatePatient(patientId:String, patientInfo:CreatePatientDto): Boolean
    fun addPrescription(prescriptionId: UUID, patientId:UUID): Boolean
    fun patientExist(patientId: UUID):Boolean
}