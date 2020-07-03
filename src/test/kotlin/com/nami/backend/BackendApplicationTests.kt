package com.nami.backend

import com.nami.backend.test.dto.TestGetDto
import com.nami.backend.test.dto.TestPostDto
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.validation.ConstraintViolation
import javax.validation.Validator


@SpringBootTest
class BackendApplicationTests {

	@Autowired
	private val validator: Validator? = null

	@Test
	@Throws(Exception::class)
	fun testPostDtoNameShouldContainWordTest() {
		// given
		val errTestGetDto = TestGetDto("1", "Name", "description")
		val testGetDto = TestGetDto("dd07fa45-805a-47da-9dc5-698296cc3cca", "NameTest", "description")

		var violations = validator?.validate(errTestGetDto)
		// then
		Assertions.assertEquals(1, violations?.size ?:-1)
		violations = validator?.validate(testGetDto)
		Assertions.assertEquals(0, violations?.size ?:-1)
	}

}
