package com.nami.backend.test

import com.nami.backend.test.dto.TestDto
import org.springframework.lang.NonNull
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("api/tests")
class TestController (private val service: TestService,
                      private val dtoMapper: TestDtoMapper) {

    @GetMapping(path = ["/{testId}"])
    fun test (@PathVariable("testId") testId: String): TestDto {
        return dtoMapper.toDto(service.getById(testId))
    }

    @PutMapping(path = ["/{testId}"])
    fun testput (@PathVariable("testId") testId: String, @NonNull @RequestBody @Validated testDto : TestDto){
        service.save(dtoMapper.toEntity(testDto));
    }
}