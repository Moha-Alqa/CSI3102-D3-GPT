package group26_HMS.pms.contracts.testStubs.repositories

import group26_HMS.pms.domain.divisionManagement.entities.Division
import group26_HMS.pms.domain.divisionManagement.repositories.DivisionRepository

class DivisionRepositoryStub:DivisionRepository {
    private val divisions: MutableMap<String,Division> = HashMap()

    override fun find(divisionId: String): Division? = divisions[divisionId]

    override fun save(division: Division): Division {
        divisions[division.id] = division
        return division
    }
}