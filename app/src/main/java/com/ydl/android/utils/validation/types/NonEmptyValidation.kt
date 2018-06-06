package com.ydl.android.utils.validation.types


import android.text.TextUtils
import com.ydl.android.utils.validation.Validation
import com.ydl.android.utils.validation.ValidationResult

/**
 * @author Ritesh Shakya
 */

class NonEmptyValidation(private val reason: String = "Non empty field") : Validation {

    override fun validate(s: String): ValidationResult<Any> {
        return if (!TextUtils.isEmpty(s.trim())) {
            ValidationResult.success(s)
        } else {
            ValidationResult.failure(reason, s)
        }
    }


}
