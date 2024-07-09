package com.xempus.data.challenge.database

import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.springframework.data.jpa.repository.JpaRepository
import java.time.Instant
import java.util.UUID

@Entity
data class Employee (
    @Id val id: UUID,
    val name: String,
    val email: String,
    val address: String,
    val dateCreated: Instant,
)

interface EmployeeRepository : JpaRepository<Employee, UUID>
