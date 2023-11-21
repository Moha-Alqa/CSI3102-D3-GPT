package group26_HMS.pms.contracts.testStubs.repositories

import group26_HMS.pms.domain.divisionManagement.entities.AdmissionRequest
import group26_HMS.pms.domain.divisionManagement.repositories.AdmissionRequestRepository
import java.util.*

class AdmissionRequestRepositoryStub:AdmissionRequestRepository {
    private var requests: MutableMap<String, AdmissionRequest> = HashMap()
    override fun find(patientId: UUID): AdmissionRequest? {
        requests.forEach { (_, request) ->
            if (request.patientId == patientId && request.status == "pending") {
                return request
            }
        }
        return null
    }

    override fun save(request: AdmissionRequest): AdmissionRequest {
        requests[request.id.toString()] = request
        return request
    }
}