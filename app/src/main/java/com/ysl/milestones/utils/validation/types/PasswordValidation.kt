package com.ysl.milestones.utils.validation.types


import com.ysl.milestones.utils.validation.Validation
import com.ysl.milestones.utils.validation.ValidationResult
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
