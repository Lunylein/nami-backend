package com.nami.backend.test.dto

import javax.validation.constraints.Size

data class TestGetDto (
        val id: String,
        @get:Size(max = 125, message = "name to long") val name: String,
        @get:Size(max = 256, message = "description to long") val description: String?
)
data class TestPostDto (
        @get:Size(max = 125, message = "name to long") val name: String,
        @get:Size(max = 256, message = "description to long") val description: String?
)