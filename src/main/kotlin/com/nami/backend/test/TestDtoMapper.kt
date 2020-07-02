package com.nami.backend.test

import com.nami.backend.test.dto.TestDto
import org.springframework.stereotype.Component
import java.util.*
import kotlin.random.Random

@Component
class TestDtoMapper {
    fun toDto(entity: TestEntity): TestDto = TestDto(
            id = entity.id.toString(),
            name = entity.name,
            description = entity.description
    )
    fun toEntity(dto: TestDto): TestEntity = TestEntity(
            id = UUID.fromString(dto.id),
            name = dto.name,
            description = dto.description,
            deleted = false,
            version = Random.nextLong()
    )
}
