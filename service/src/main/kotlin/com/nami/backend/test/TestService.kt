package com.nami.backend.test

import org.springframework.stereotype.Service
import java.util.*
import kotlin.random.Random

@Service
class TestService (val repository: TestRepository) {
    fun getAll(): List<TestEntity> = listOf()

    fun getById(id: String): TestEntity = repository.findById(UUID.fromString(id)).get()
    fun create(name: String, description: String?): TestEntity {
        val testEntity = TestEntity(
                name = name,
                description = description,
                deleted = false,
                version = Random.nextLong()
        )

        return repository.save(testEntity)
    }
}
