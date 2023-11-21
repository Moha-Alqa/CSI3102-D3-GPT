package group26_HMS.pms.domain.patientManagement.factories

import group26_HMS.pms.application.dtos.queries.CreateAddressDto
import group26_HMS.pms.application.dtos.queries.CreatePatientDto
import group26_HMS.pms.application.dtos.queries.CreatePatientKinDto
import group26_HMS.pms.domain.patientManagement.entities.Address
import group26_HMS.pms.domain.patientManagement.entities.Patient
import group26_HMS.pms.domain.patientManagement.entities.PatientKin

interface PatientFactory {
    fun createPatient(patientInfo:CreatePatientDto): Patient
    fun createPatientKin(kinInfo: CreatePatientKinDto): PatientKin
    fun createAddress(addrInfo: CreateAddressDto): Address
}