package group26_HMS.pms.application.usecases

import group26_HMS.pms.application.dtos.queries.CreatePatientDto
import java.util.UUID

interface UpdatePatientFile {
    fun updatePatientFile(patientId:UUID, patientInfo:CreatePatientDto): Boolean
    fun checkStaffPrivilege(staffId:UUID):Boolean
}