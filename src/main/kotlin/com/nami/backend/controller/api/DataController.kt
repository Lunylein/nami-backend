package com.nami.backend.controller.api

import com.nami.backend.model.Serie
import com.nami.backend.service.DataService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("api/v1")
class DataController {
        @Autowired
        private lateinit var dataService: DataService

        @GetMapping(path = ["/{serie}"])
        fun series (@PathVariable("serie") serie: String): List<Serie> {
                return dataService.series(serie).filter { it.series == serie };
        }

}