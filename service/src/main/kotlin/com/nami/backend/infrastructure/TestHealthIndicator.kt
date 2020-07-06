package com.nami.backend.infrastructure

import org.springframework.boot.actuate.health.Health

import org.springframework.boot.actuate.health.HealthIndicator
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class TestHealthIndicator : HealthIndicator {
    override fun health(): Health {
        val errorCode: Int = check() // perform some specific health check
        return if (errorCode != 0) {
            Health.down().withDetail("Randomizer responded with \"Server Down\"", errorCode).build()
        } else Health.up().build()
    }

    private fun check(): Int {
        return if(Random.nextBoolean()){
            0
        } else {
            -1
        }
    }
}