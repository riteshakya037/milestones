package com.riteshakya.milestones.utils.validation.types


import com.riteshakya.milestones.utils.validation.Validation
import com.riteshakya.milestones.utils.validation.ValidationResult
import java.util.regex.Pattern

/**
 * @author Ritesh Shakya
 */

class PasswordValidation(private val reason: String) : Validation {

    override fun validate(s: String): ValidationResult<Any> {
        val pattern = Pattern.compile("^(?=.*\\d)[A-Za-z\\d#\$@!%&*?]{6,}\$")
        val matcher = pattern.matcher(s)
        val isValid = matcher.matches()
        return if (isValid) ValidationResult.success(s) else ValidationResult.failure(reason, s)
    }
}
