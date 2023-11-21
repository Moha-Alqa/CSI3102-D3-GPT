package group26_HMS.pms.contracts.steps

import group26_HMS.pms.application.dtos.queries.AdmitPatientDto
import group26_HMS.pms.application.dtos.queries.CreatePatientDto
import group26_HMS.pms.application.usecases.AdmitPatient
import group26_HMS.pms.application.usecases.RegisterPatient
import group26_HMS.pms.application.usecases.RegisterStaff
import group26_HMS.pms.application.usecases.implementation.AdmitPatientImpl
import group26_HMS.pms.application.usecases.implementation.RegisterPatientImpl
import group26_HMS.pms.contracts.testStubs.factories.AdmissionFactoryStub
import group26_HMS.pms.contracts.testStubs.factories.AdmissionRequestFactoryStub
import group26_HMS.pms.contracts.testStubs.factories.PatientFactoryStub
import group26_HMS.pms.contracts.testStubs.repositories.*
import group26_HMS.pms.contracts.testStubs.services.EventEmitterStub
import group26_HMS.pms.domain.divisionManagement.entities.Division
import group26_HMS.pms.domain.divisionManagement.entities.PatientAdmission
import group26_HMS.pms.domain.divisionManagement.facade.implementation.DivisionFacadeImpl
import group26_HMS.pms.domain.divisionManagement.factories.AdmissionRequestFactory
import group26_HMS.pms.domain.divisionManagement.repositories.AdmissionRequestRepository
import group26_HMS.pms.domain.divisionManagement.repositories.DivisionRepository
import group26_HMS.pms.domain.patientManagement.entities.Patient
import group26_HMS.pms.domain.patientManagement.facade.implementation.PatientFacadeImpl
import group26_HMS.pms.domain.userManagement.entities.Position
import group26_HMS.pms.domain.userManagement.entities.Staff
import io.cucumber.java8.En
import io.cucumber.java8.Scenario
import org.assertj.core.api.Assertions
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.util.*

class StepsDefinition:En {
    //domain elements here
    private var eventEmitter = EventEmitterStub()
    private var patientRepository = PatientRepositoryStub()
    private var patientFactory = PatientFactoryStub()
    private var userRepository = UserRepositoryStub()
    private var admissionFactory = AdmissionFactoryStub()
    private var admissionRepository = AdmissionRepositoryStub()
    private var admissionRequestRepository  = AdmissionRequestRepositoryStub()
    private var admissionRequestFactory = AdmissionRequestFactoryStub()
    private var divisionRepository = DivisionRepositoryStub()

    @Mock
    private var patientInfo:CreatePatientDto? = null
    private var admissionInfo:AdmitPatientDto? = null
    private var newPatientId: UUID? = null
    private var newPatient: Patient? = null
    private var newNurse: Staff? = null
    private var divisionId: String? = null
    private var user:Staff? = null
    private var patientId:UUID? = null
    private var newAdmissionId:UUID? = null
    private var newAdmission:PatientAdmission? = null
    private var currentDivision:Division? = null

    init {
        Before {_: Scenario ->
            MockitoAnnotations.openMocks(this)
        }
        //UC4 -- Register Patient
        Given("The Medical Staff Member is logged in") {
            user = registerStaff(userRepository)
            Assertions.assertThat(user).isNotNull
        }
        Given("Medical Staff Member enters requested information") {
            patientInfo = setPatientInfo()
            Assertions.assertThat(patientInfo).isNotNull
        }
        When("the application command registerPatient is invoked") {
            val patientFacade = PatientFacadeImpl(
                patientFactory,
                patientRepository,
                eventEmitter
            )
            val uc:RegisterPatient = RegisterPatientImpl(patientFacade)
            newPatientId = patientInfo?.let { uc.addPatient(it) }
        }
        Then("HMS issues a new identification number for Patient") {
            Assertions.assertThat(newPatientId).isNotNull()
        }
        Then("new patient is registered") {
            newPatient = newPatientId?.let { patientRepository.find(it.toString()) }
            Assertions.assertThat(newPatient).isNotNull
            Assertions.assertThat(newPatient?.firstName).isEqualTo(patientInfo?.firstName)
            Assertions.assertThat(newPatient?.lastName).isEqualTo(patientInfo?.lastName)
            Assertions.assertThat(newPatient?.insuranceNum).isEqualTo(patientInfo?.insuranceNum)
            Assertions.assertThat(newPatient?.email).isEqualTo(patientInfo?.email)
            Assertions.assertThat(newPatient?.phoneNumber).isEqualTo(patientInfo?.phoneNumber)
            Assertions.assertThat(newPatient?.dateOfBirth).isEqualTo(patientInfo?.dateOfBirth)
            Assertions.assertThat(newPatient?.gender).isEqualTo(patientInfo?.gender)
            Assertions.assertThat(newPatient?.maritalStatus).isEqualTo(patientInfo?.maritalStatus)
            Assertions.assertThat(newPatient?.externalDoctor).isEqualTo(patientInfo?.externalDoctor)
            Assertions.assertThat(newPatient?.address?.streetNumber).isEqualTo(patientInfo?.address?.streetNumber)
            Assertions.assertThat(newPatient?.address?.streetName).isEqualTo(patientInfo?.address?.streetName)
            Assertions.assertThat(newPatient?.address?.city).isEqualTo(patientInfo?.address?.city)
            Assertions.assertThat(newPatient?.address?.country).isEqualTo(patientInfo?.address?.country)
            Assertions.assertThat(newPatient?.address?.postalCode).isEqualTo(patientInfo?.address?.postalCode)
            Assertions.assertThat(newPatient?.address?.unitNumber).isEqualTo(patientInfo?.address?.unitNumber)
            Assertions.assertThat(newPatient?.nextOfKin?.fullName).isEqualTo(patientInfo?.nextOfKin?.fullName)
            Assertions.assertThat(newPatient?.nextOfKin?.relationshipToPatient).isEqualTo(patientInfo?.nextOfKin?.relationship)
            Assertions.assertThat(newPatient?.nextOfKin?.phoneNum).isEqualTo(patientInfo?.nextOfKin?.phoneNum)
            Assertions.assertThat(newPatient?.nextOfKin?.address?.streetNumber).isEqualTo(patientInfo?.nextOfKin?.address?.streetNumber)
            Assertions.assertThat(newPatient?.nextOfKin?.address?.streetName).isEqualTo(patientInfo?.nextOfKin?.address?.streetName)
            Assertions.assertThat(newPatient?.nextOfKin?.address?.city).isEqualTo(patientInfo?.nextOfKin?.address?.city)
            Assertions.assertThat(newPatient?.nextOfKin?.address?.country).isEqualTo(patientInfo?.nextOfKin?.address?.country)
            Assertions.assertThat(newPatient?.nextOfKin?.address?.postalCode).isEqualTo(patientInfo?.nextOfKin?.address?.postalCode)
            Assertions.assertThat(newPatient?.nextOfKin?.address?.unitNumber).isEqualTo(patientInfo?.nextOfKin?.address?.unitNumber)
            Assertions.assertThat(newPatient?.firstName).isEqualTo(patientInfo?.firstName)
        }
        Given("the information is incomplete") {
            patientInfo = null
            Assertions.assertThat(patientInfo).isNull()
        }
        Then("HMS displays incomplete information error message") {
            //no implementation
        }
        Then("patient is not registered") {
            newPatient = newPatientId?.let { patientRepository.find(it.toString()) }
            Assertions.assertThat(newPatient).isNull()
        }

        //UC-8 -- admit Patient
        Given("charge nurse is logged in") {
            newNurse = registerNurse(userRepository)
            Assertions.assertThat(newNurse).isNotNull
            Assertions.assertThat(newNurse?.position?.position).isEqualTo(Position.CHARGE_NURSE)
        }

        Given("admission information is provided") {
            admissionInfo = setAdmissionInfo()
        }

        Given("division is incomplete") {
            val divisionFacade = DivisionFacadeImpl (
                admissionFactory,
                admissionRequestFactory,
                admissionRepository,
                admissionRequestRepository,
                divisionRepository,
                eventEmitter
            )
            divisionId = newNurse?.position?.division
            //create mock division
            currentDivision = createDivision(newNurse!!.staffId, divisionId!!,"incomplete", divisionRepository)
            Assertions.assertThat(divisionId).isNotNull()
            Assertions.assertThat(divisionFacade.divisionIsAvailable(divisionId!!)).isTrue()
        }

        Given("division is complete") {
            val divisionFacade = DivisionFacadeImpl (
                admissionFactory,
                admissionRequestFactory,
                admissionRepository,
                admissionRequestRepository,
                divisionRepository,
                eventEmitter
            )
            divisionId = newNurse?.position?.division
            //create mock division
            currentDivision = createDivision(newNurse!!.staffId, divisionId!!,"complete", divisionRepository)
            Assertions.assertThat(divisionId).isNotNull()
            Assertions.assertThat(divisionFacade.divisionIsAvailable(divisionId!!)).isFalse()
        }
            
        When("the application command admitPatient is invoked") {
            val divisionFacade = DivisionFacadeImpl (
                admissionFactory,
                admissionRequestFactory,
                admissionRepository,
                admissionRequestRepository,
                divisionRepository,
                eventEmitter
            )
            val uc: AdmitPatient = AdmitPatientImpl(divisionFacade)
            newAdmissionId = admissionInfo?.let { uc.admitPatient(it,newNurse!!.staffId) }
            patientId = admissionInfo?.patientId
        }  

        Then("charge nurse is notified their division is complete") {
            Assertions.assertThat(currentDivision?.isComplete()).isTrue()
        }

        Then("gives charge nurse possibility to request patient admission") {
            //no implementation
        }

        Then("patient is admitted to the charge nurse's division") {
            newAdmission = newAdmissionId?.let { admissionRepository.find(patientId!!) }
            Assertions.assertThat(newAdmission).isNotNull
            Assertions.assertThat(newAdmission?.localDoctor).isEqualTo(admissionInfo?.localDoctor)
            Assertions.assertThat(newAdmission?.roomNumber).isEqualTo(admissionInfo?.roomNumber)
            Assertions.assertThat(newAdmission?.bedNumber).isEqualTo(admissionInfo?.bedNumber)
            Assertions.assertThat(newAdmission?.division).isEqualTo(admissionInfo?.division)
            Assertions.assertThat(newAdmission?.patientId).isEqualTo(admissionInfo?.patientId.toString())
            Assertions.assertThat(newAdmission?.insuranceNumber).isEqualTo(admissionInfo?.insuranceNum)
            Assertions.assertThat(newAdmission?.division).isEqualTo(currentDivision?.id)
        }
        After {_: Scenario ->

            eventEmitter = EventEmitterStub()
            patientRepository = PatientRepositoryStub()
            patientFactory = PatientFactoryStub()
            userRepository =  UserRepositoryStub()
            admissionFactory = AdmissionFactoryStub()
            admissionRepository = AdmissionRepositoryStub()
            admissionRequestFactory = AdmissionRequestFactoryStub()
            admissionRequestRepository = AdmissionRequestRepositoryStub()
            divisionRepository = DivisionRepositoryStub()

            patientInfo = null
            admissionInfo = null
            newPatientId = null
            newPatient = null
            newNurse = null
            divisionId = null
            user = null
            newAdmissionId = null
            newAdmission = null
            currentDivision = null
        }
    }
}