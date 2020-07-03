package com.nami.backend.test

import java.lang.annotation.Documented
import java.lang.annotation.ElementType
import java.lang.annotation.ElementType.FIELD
import java.lang.annotation.RetentionPolicy
import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass


@MustBeDocumented
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [UUIDValidator::class])
annotation class UUIDConstraint(val message: String = "{Must contain test}", val groups: Array<KClass<*>> = [], val payload: Array<KClass<out Any>> = [])