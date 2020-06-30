package com.nami.backend.service

import com.nami.backend.model.Serie
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
@Component
class DataService{

    //private lateinit var serieDao: SerieDao

    fun series (serie: String): List<Serie> {
        val list = mutableListOf<Serie>()
        list.add(Serie("f1", "url", LocalDateTime.now()))
        list.add(Serie("f1", "url1", LocalDateTime.now()))
        list.add(Serie("f1", "url2", LocalDateTime.now()))
        list.add(Serie("f1", "url3", LocalDateTime.now()))
        list.add(Serie("f1", "url4", LocalDateTime.now()))
        return list;
    }
}