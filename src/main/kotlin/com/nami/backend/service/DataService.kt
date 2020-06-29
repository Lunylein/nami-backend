package com.nami.backend.service

import com.nami.backend.dao.SerieDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class DataService {
    private val serieDao: SerieDao? = null

    @Autowired
    fun DataService(@Qualifier("fake") serieDao: SerieDao?) {
     //   this.serieDao = serieDao
    }
}