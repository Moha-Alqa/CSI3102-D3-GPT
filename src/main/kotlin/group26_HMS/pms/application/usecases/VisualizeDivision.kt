package group26_HMS.pms.application.usecases

import group26_HMS.pms.application.dtos.queries.VisualizeDivisionDto
import group26_HMS.pms.application.supporting_object.DivisionInfo
import java.util.*

interface VisualizeDivision {
    fun checkStaffLoggedIn(visualizeDivision: VisualizeDivisionDto): Boolean
    fun checkDivision(divisionId: UUID): Boolean
    fun visualizeDivisionInfo(divisionId:UUID): DivisionInfo
}