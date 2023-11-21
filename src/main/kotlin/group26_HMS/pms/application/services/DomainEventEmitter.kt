package group26_HMS.pms.application.services

import group26_HMS.pms.domain.common.DomainEvent

interface DomainEventEmitter {
    fun emit(event:DomainEvent)
}