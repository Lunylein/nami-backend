package com.nami.backend.db.repository

import com.nami.backend.db.SerieDao
import com.nami.backend.model.Serie
import org.springframework.stereotype.Repository
import java.util.*
//@Repository("fake")
object FakeSerieRepository : SerieDao {
    private val DB: List<Serie> = ArrayList<Serie>()
}
