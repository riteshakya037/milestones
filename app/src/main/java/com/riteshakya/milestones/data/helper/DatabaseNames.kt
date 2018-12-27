package com.riteshakya.milestones.data.helper

import java.io.File


object DatabaseNames {
    val TABLE_GOALS = "goals"
    val TABLE_USER_DATA = "users"

    fun createPath(vararg individualTables: String): String {
        val output = StringBuilder()
        val delimiter = File.separator
        var and = false
        for (e in individualTables) {
            if (and) {
                output.append(delimiter)
            }
            output.append(e)
            and = true
        }
        return output.toString()
    }
}