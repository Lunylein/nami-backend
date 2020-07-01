package com.nami.backend.test

import org.springframework.stereotype.Service
import java.util.*

@Service
class TestService {
    fun getAll(): List<TestEntity> = listOf()

    fun getById(id: String): TestEntity = TestEntity(
            id = UUID.randomUUID(),
            version = 1L,
            deleted = false,
            name = "test name",
            description = "test description"
    )
}
