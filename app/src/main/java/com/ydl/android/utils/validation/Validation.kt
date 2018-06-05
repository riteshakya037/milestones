package com.ydl.android.utils.validation

/**
 * @author Ritesh Shakya
 */

interface Validation {
    fun validate(s: String): ValidationResult<Any>
}
