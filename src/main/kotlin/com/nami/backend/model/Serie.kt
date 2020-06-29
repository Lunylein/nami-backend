package com.nami.backend.model

import java.net.URL
import java.time.LocalDateTime

data class Serie(val series: String,
                 val url: String,
                 val lastUpdate: LocalDateTime
            )