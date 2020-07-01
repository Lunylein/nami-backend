package com.nami.backend.test

import com.nami.backend.test.dto.TestDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/tests")
class TestController (private val service: TestService,
                      private val dtoMapper: TestDtoMapper) {

    @GetMapping(path = ["/{testId}"])
    fun series (@PathVariable("testId") testId: String): TestDto {
        return dtoMapper.toDto(service.getById(testId))
    }

}