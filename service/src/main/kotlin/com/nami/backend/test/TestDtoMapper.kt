package com.nami.backend.test

import com.nami.backend.test.dto.TestGetDto
import org.springframework.stereotype.Component

@Component
class TestDtoMapper {
    fun toDto(entity: TestEntity): TestGetDto = TestGetDto(
            id = entity.id.toString(),
            name = entity.name,
            description = entity.description
    )
}
