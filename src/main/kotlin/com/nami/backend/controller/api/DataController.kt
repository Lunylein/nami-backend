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
  /*      private val DataService: dataService? = null

        @Autowired
        fun DataController(productService: DataService?) {
                this.dataService = dataService
        }*/
        @GetMapping(path = ["/{serie}"])
        fun series (@PathVariable("serie") serie: String): List<Serie> {
                val list = mutableListOf<Serie>()
                list.add(Serie("f1", "url", LocalDateTime.now()))
                list.add(Serie("f1", "url1", LocalDateTime.now()))
                list.add(Serie("f1", "url2", LocalDateTime.now()))
                list.add(Serie("f1", "url3", LocalDateTime.now()))
                list.add(Serie("f1", "url4", LocalDateTime.now()))
                return list.filter { it.series == serie };
        }

}