package group26_HMS.pms.contracts.testStubs.services

import group26_HMS.pms.application.services.DomainEventEmitter
import group26_HMS.pms.domain.common.DomainEvent

class EventEmitterStub:DomainEventEmitter {
    private val emitted:MutableList<DomainEvent> = ArrayList()

    override fun emit(event: DomainEvent) {
        emitted.add(event)
    }
}