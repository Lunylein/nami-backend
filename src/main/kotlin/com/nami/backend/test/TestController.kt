package com.nami.backend.test

import com.nami.backend.test.dto.TestDto
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

    @PostMapping(path = ["/{testId}"])
    fun testput (@PathVariable("testId") testId: String){
        service.save(TestEntity(UUID.fromString(testId), 1, false, "asdasd", "asd"))
    }
}