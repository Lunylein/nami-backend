package com.nami.backend.datasource

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PostgresDatasource {
    @Bean
    @ConfigurationProperties("app.datasource")
    fun hikariDataSource(): HikariDataSource {
        return DataSourceBuilder
                .create()
                .type(HikariDataSource::class.java)
                .build()
    }
}