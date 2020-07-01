package com.nami.backend.test

import com.nami.backend.test.dto.TestDto
import org.springframework.stereotype.Component

@Component
class TestDtoMapper {
    fun toDto(entity: TestEntity): TestDto = TestDto(
            id = entity.id.toString(),
            name = entity.name,
            description = entity.description
    )
}
