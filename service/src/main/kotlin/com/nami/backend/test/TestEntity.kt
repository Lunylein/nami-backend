package com.nami.backend.test

import com.nami.backend.common.AbstractEntity
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity(name = "Test")
@Table(name = "tests")
class TestEntity(
        @Id @GeneratedValue override var id: UUID? = null,
        override var version: Long,
        override var deleted: Boolean,
        var name: String,
        var description: String?

): AbstractEntity<UUID>() {
    override fun toString(): String {
        return "Test[id=${id}, name=${name}, description=${description}]"
    }
}