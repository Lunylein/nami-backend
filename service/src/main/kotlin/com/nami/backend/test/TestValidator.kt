package com.nami.backend.test

import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class UUIDValidator : ConstraintValidator<UUIDConstraint?, String?> {
    override fun initialize(testName: UUIDConstraint?) {}
    override fun isValid(testField: String?, cxt: ConstraintValidatorContext?): Boolean {
        val uuidRegex = "^[0-9A-Fa-f]{8}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{12}$".toRegex();
        return uuidRegex.matchEntire(testField ?: "")?.groupValues ?: null != null
    }
}