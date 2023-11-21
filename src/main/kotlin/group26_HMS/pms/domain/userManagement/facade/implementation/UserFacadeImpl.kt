package group26_HMS.pms.domain.userManagement.facade.implementation

import group26_HMS.pms.application.dtos.queries.StaffRegisterDto
import group26_HMS.pms.application.services.DomainEventEmitter
import group26_HMS.pms.domain.userManagement.entities.Position
import group26_HMS.pms.domain.userManagement.events.StaffRegistered
import group26_HMS.pms.domain.userManagement.facade.UserFacade
import group26_HMS.pms.domain.userManagement.factories.UserFactory
import group26_HMS.pms.domain.userManagement.repositories.UserRepository
import java.util.Date
import java.util.UUID

class UserFacadeImp(    
    private var userFactory: UserFactory,
    private var userRepository: UserRepository,
    private var eventEmitter: DomainEventEmitter):UserFacade{

    override fun registerStaff(staffInfo:StaffRegisterDto): UUID{
        var staff = userFactory.createStaff(staffInfo)

        userRepository.save(staff)        
        eventEmitter.emit(StaffRegistered(
            UUID.randomUUID(),
            Date(),
            staff.staffId.toString()
        ))

        return staff.staffId        
    }

    override fun doctorExists(staffId: UUID): Boolean {
        val position = userRepository.getPosition(staffId)
        return position == Position.DOCTOR
    }
}