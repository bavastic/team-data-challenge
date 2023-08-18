package com.xempus.data.challenge.kafka

import org.springframework.kafka.annotation.KafkaHandler
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.core.KafkaOperations
import org.springframework.stereotype.Component
import java.util.UUID

@Component
@KafkaListener(topics = ["employee"])
class KafkaListener(
    private val operations: KafkaOperations<UUID, ExportEmployeeEvent>
) {

    @KafkaHandler
    fun listen(event: EmployeeCreatedEvent) {

        // TODO


        exportEmployee(event.employeeId)
    }

    @KafkaHandler
    fun listen(event: EmployeeUpdatedEvent) {

        // TODO

        exportEmployee(event.employeeId)
    }

    @KafkaHandler
    fun listen(event: EmployeeActivatedEvent) {

        // TODO

        exportEmployee(event.employeeId)
    }

    private fun exportEmployee(employeeId: UUID){
        // event which triggers update to downstream system
        operations.send(UUID.randomUUID().toString(),
            ExportEmployeeEvent(employeeId)
        )
    }

}