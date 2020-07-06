package com.nami.backend.test

import javax.validation.Constraint
import kotlin.reflect.KClass


@MustBeDocumented
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [UUIDValidator::class])
annotation class UUIDConstraint(val message: String = "{Must contain test}", val groups: Array<KClass<*>> = [], val payload: Array<KClass<out Any>> = [])