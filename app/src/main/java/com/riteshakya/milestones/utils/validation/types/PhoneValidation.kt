package com.riteshakya.milestones.utils.validation.types


import com.riteshakya.milestones.utils.validation.Validation
import com.riteshakya.milestones.utils.validation.ValidationResult
import java.util.regex.Pattern

/**
 * @author Ritesh Shakya
 */

class PhoneValidation(private val reason: String) : Validation {

    override fun validate(s: String): ValidationResult<Any> {
        val pattern = Pattern.compile("0\\d{9}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}")
        val matcher = pattern.matcher(s)
        val isValid = matcher.matches()
        return if (isValid) ValidationResult.success(s) else ValidationResult.failure(reason, s)
    }
}
