package com.riteshakya.milestones.data.exceptions

/**
 * author riteshakya037
 */
class EmailNotFoundException : RuntimeException() {
    override val message: String?
        get() = "The email you provided doesn't exist. Please try again."
}