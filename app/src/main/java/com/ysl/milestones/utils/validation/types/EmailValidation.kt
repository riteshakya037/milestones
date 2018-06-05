package com.ysl.milestones.utils.validation.types


import com.ysl.milestones.utils.validation.Validation
import com.ysl.milestones.utils.validation.ValidationResult

/**
 * @author Ritesh Shakya
 */

class EmailValidation(private val reason: String) : Validation {
    private val ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\" + ".[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$"

    override fun validate(s: String): ValidationResult<Any> {
        val p = java.util.regex.Pattern.compile(ePattern)
        val m = p.matcher(s)
        val isValid = m.matches()
        return if (isValid) {
            ValidationResult.success(s)
        } else {
            ValidationResult.failure(reason, s)
        }
    }


}
