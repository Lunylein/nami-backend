package com.nami.backend.dao

import com.nami.backend.model.Serie
import org.springframework.stereotype.Repository
import java.util.*
//@Repository("fake")
object FakeSerieDataAccessService : SerieDao {
    private val DB: List<Serie> = ArrayList<Serie>()
}