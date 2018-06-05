package com.ysl.milestones.utils.validation

/**
 * @author Ritesh Shakya
 */

interface Validation {
    fun validate(s: String): ValidationResult<Any>
}
