package group26_HMS.pms.application.usecases

import group26_HMS.pms.application.dtos.queries.CreatePatientDto
import java.util.*

interface ConsultPatientFile {
    fun getPatientFile(patientId: UUID):CreatePatientDto
    fun checkPatientId(patientId: UUID):Boolean

}