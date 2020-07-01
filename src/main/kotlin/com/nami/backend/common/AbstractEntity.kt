package com.nami.backend.common

abstract class AbstractEntity<T> {

    abstract val id: T
    abstract val version: Long
    abstract var deleted: Boolean

    open fun markAsDeleted() {
        deleted = true
    }
}