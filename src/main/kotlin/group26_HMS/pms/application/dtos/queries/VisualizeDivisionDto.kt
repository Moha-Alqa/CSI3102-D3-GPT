package group26_HMS.pms.application.dtos.queries

import java.util.UUID

data class VisualizeDivisionDto (
    val chargeNurseId: UUID, //user identification/employee number
    val divisionId: UUID
)