package com.riteshakya.milestones.data.exceptions

/**
 * author riteshakya037
 */
class ServerException : RuntimeException() {
    override val message: String?
        get() = "There seems to be an error in our server, please contact our customer support"
}