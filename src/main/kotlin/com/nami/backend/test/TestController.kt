package com.nami.backend.test

import com.nami.backend.test.dto.TestGetDto
import com.nami.backend.test.dto.TestPostDto
import org.springframework.lang.NonNull
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/tests")
class TestController (private val service: TestService,
                      private val dtoMapper: TestDtoMapper) {

    @GetMapping(path = ["/{testId}"])
    fun test (@PathVariable("testId") testId: String): TestGetDto {
        return dtoMapper.toDto(service.getById(testId))
    }

    @PostMapping()
    fun testPost (@NonNull @RequestBody @Validated testDto : TestPostDto): TestGetDto {
        val testEntity = service.create(testDto.name, testDto.description);
        return dtoMapper.toDto(testEntity)
    }
}
