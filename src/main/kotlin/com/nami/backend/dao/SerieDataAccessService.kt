package com.nami.backend.dao

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

//@Repository("postgres")
class SerieDataAccessService(private val jdbcTemplate: JdbcTemplate) : SerieDao