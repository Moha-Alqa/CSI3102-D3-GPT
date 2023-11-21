package group26_HMS.pms.application.usecases

import group26_HMS.pms.application.dtos.queries.AdmitPatientDto
import java.util.UUID

interface AdmitPatient {
    fun admitPatient(admitInfo: AdmitPatientDto, chargeNurseId:UUID):UUID?
}