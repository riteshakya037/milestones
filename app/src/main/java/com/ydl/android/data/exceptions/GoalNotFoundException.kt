package com.ydl.android.data.exceptions

/**
 * author riteshakya037
 */
class GoalNotFoundException : RuntimeException() {
    override val message: String?
        get() = "The goal you are searching for doesn't exist. Please try again."
}