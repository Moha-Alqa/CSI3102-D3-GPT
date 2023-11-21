package group26_HMS.pms.domain.divisionManagement.repositories

import group26_HMS.pms.domain.divisionManagement.entities.Division

interface DivisionRepository {
    fun find(divisionId:String):Division?
    fun save(division:Division):Division
}