package com.nami.backend.db.repository

import com.nami.backend.db.SerieDao
import org.springframework.jdbc.core.JdbcTemplate

//@Repository("postgres")
class SerieRepository(private val jdbcTemplate: JdbcTemplate) : SerieDao