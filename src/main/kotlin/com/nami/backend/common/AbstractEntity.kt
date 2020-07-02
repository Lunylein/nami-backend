package com.nami.backend.common

import java.util.*
import javax.persistence.GeneratedValue
import javax.persistence.Id

abstract class AbstractEntity<T> {

    abstract val id: T?
    abstract val version: Long
    abstract var deleted: Boolean

    open fun markAsDeleted() {
        deleted = true
    }
}