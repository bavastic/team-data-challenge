package com.xempus.data.challenge.kafka

import java.time.Instant
import java.util.UUID

data class EmployeeCreatedEvent (
    val employeeId: UUID,
    val name: String,
    val email: String,
    val address: String,
    val dateCreated: Instant,
    )

data class EmployeeUpdatedEvent (
    val employeeId: UUID,
    val name: String,
    val email: String,
    val address: String,
    val dateUpdated: Instant,
)

data class ExportEmployeeEvent(
    val employeeId: UUID,
)
