package group26_HMS.pms.contracts.steps

import group26_HMS.pms.application.dtos.queries.AdmitPatientDto
import group26_HMS.pms.application.dtos.queries.CreateAddressDto
import group26_HMS.pms.application.dtos.queries.CreatePatientDto
import group26_HMS.pms.application.dtos.queries.CreatePatientKinDto
import group26_HMS.pms.domain.divisionManagement.repositories.DivisionRepository
import group26_HMS.pms.domain.patientManagement.entities.Address
import group26_HMS.pms.domain.patientManagement.entities.Patient
import group26_HMS.pms.domain.patientManagement.entities.PatientKin
import group26_HMS.pms.domain.patientManagement.repositories.PatientRepository
import group26_HMS.pms.domain.userManagement.entities.Staff
import group26_HMS.pms.domain.userManagement.repositories.UserRepository
import group26_HMS.pms.domain.divisionManagement.entities.Division
import group26_HMS.pms.domain.userManagement.entities.Position
import group26_HMS.pms.domain.userManagement.entities.StaffPosition
import java.time.LocalDate
import java.util.*

fun registerStaff(userRepository: UserRepository):Staff {
    val staff = Staff(
        UUID.randomUUID(),
        "Alex",
        "Rayne",
        "342asdf",
        "aRayne@hospital.com",
        "453-149-1239",
        StaffPosition (
            Position.MEDICAL_STAFF,
            "Ward 0"
        )
    )
    userRepository.save(staff)
    return staff
}
fun setPatientInfo():CreatePatientDto {
    return CreatePatientDto(
        UUID.randomUUID(),
        "John",
        "Smith",
        123456789,
        CreateAddressDto(
            12,
            "McLowan",
            "Ottawa",
            "Ontario",
            "Canada",
            "J3N 4S1"
        ),
        "JSmith@mail.com",
        "111-222-3333",
        LocalDate.of(2000, 5, 12),
        "M",
        "single",
        "19023",
        CreatePatientKinDto(
            "Jane Smith",
            "Mother",
            CreateAddressDto (
                12,
                "McLowan",
                "Ottawa",
                "Ontario",
                "Canada",
                "J3N 4S1"
            ),
            "111-333-4444"
        )
    )
}

fun registerNurse(userRepository: UserRepository):Staff {
    val staff = Staff(
        UUID.randomUUID(),
        "Max",
        "Doe",
        "123",
        "nurse@hospital.com",
        "123-452-1232",
        StaffPosition (
            Position.CHARGE_NURSE,
            "Ward 0"
        )
    )
    userRepository.save(staff)
    return staff
}

fun setAdmissionInfo():AdmitPatientDto {
    return AdmitPatientDto(
        UUID.randomUUID().toString(),
        "Ward 0",
        12,
        1,
        UUID.randomUUID()
    )
}

fun createDivision(nurseId:UUID, divisionId:String, status:String, divisionRepository: DivisionRepository):Division {
    val division = Division(
        divisionId,
        "TestDivision",
        nurseId,
        "Building A",
        2,
        2341,
        status
    )
    division.setAvailableBeds(listOf(1,2))
    divisionRepository.save(division)
    return division
}

fun createPatient(patientRepository: PatientRepository): Patient {
    val patient = Patient(UUID.randomUUID(),
        "John",
        "Smith",
        123456789,
        createAddress(),
        "JSmith@mail.com",
        "111-222-3333",
        LocalDate.of(2000, 5, 12),
        "M",
        "single",
        "19023",
        createPatientKin()
    )
    patientRepository.save(patient)
    return patient
}
fun createPatientKin(): PatientKin {
    return PatientKin(
        "Jane Smith",
        "Mother",
        createAddress(),
        "111-333-4444"
    )
}
fun createAddress():Address {
    return Address (
        12,
        "McLowan",
        "Ottawa",
        "Ontario",
        "Canada",
        "J3N 4S1"
    )
}
