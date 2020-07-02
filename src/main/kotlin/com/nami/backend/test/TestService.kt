package com.nami.backend.test

import org.springframework.stereotype.Service
import java.util.*

@Service
class TestService (val repository: TestRepository) {
    fun getAll(): List<TestEntity> = listOf()

    fun getById(id: String): TestEntity = repository.findById(UUID.fromString(id)).get()
    fun save(entity: TestEntity): TestEntity = repository.save(entity)
}
