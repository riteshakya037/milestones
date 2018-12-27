package com.riteshakya.milestones.data.exceptions

/**
 * author riteshakya037
 */
open class GenericMessageException(private val errorMessage: String) : RuntimeException() {
    open val title: String
        get() = ""
    override val message: String?
        get() = errorMessage
}