package group26_HMS.pms.contracts.testStubs.factories

import group26_HMS.pms.application.dtos.queries.CreateAddressDto
import group26_HMS.pms.application.dtos.queries.CreatePatientDto
import group26_HMS.pms.application.dtos.queries.CreatePatientKinDto
import group26_HMS.pms.domain.patientManagement.entities.Address
import group26_HMS.pms.domain.patientManagement.entities.Patient
import group26_HMS.pms.domain.patientManagement.entities.PatientKin
import group26_HMS.pms.domain.patientManagement.factories.PatientFactory
import java.util.*

class PatientFactoryStub:PatientFactory {
    override fun createPatient(patientInfo: CreatePatientDto): Patient {
        return Patient(UUID.randomUUID(),
            patientInfo.firstName,
            patientInfo.lastName,
            patientInfo.insuranceNum,
            createAddress(patientInfo.address),
            patientInfo.email,
            patientInfo.phoneNumber,
            patientInfo.dateOfBirth,
            patientInfo.gender,
            patientInfo.maritalStatus,
            patientInfo.externalDoctor,
            createPatientKin(patientInfo.nextOfKin))
    }

    override fun createPatientKin(kinInfo: CreatePatientKinDto): PatientKin {
        return PatientKin(kinInfo.fullName,
            kinInfo.relationship,
            createAddress(kinInfo.address),
            kinInfo.phoneNum
        )
    }

    override fun createAddress(addrInfo: CreateAddressDto): Address {
        return Address(addrInfo.streetNumber,
            addrInfo.streetName,
            addrInfo.city,
            addrInfo.state,
            addrInfo.country,
            addrInfo.postalCode,
            addrInfo.unitNumber
        )
    }
}