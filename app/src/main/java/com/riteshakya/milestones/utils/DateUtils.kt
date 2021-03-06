package com.riteshakya.milestones.utils

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import java.util.concurrent.TimeUnit

class DateUtils {
    companion object {
        @JvmStatic
        fun getIncomingDateFormat(date: String): DateTime = DateTimeFormat.forPattern("MMM dd, yyyy").parseDateTime(date)


        @JvmStatic
        fun getOutGoingDateFormat(mDate: DateTime): String = DateTimeFormat.forPattern("MMM dd, yyyy").print(mDate)

        @JvmStatic
        fun getDaysBetween(earlier: DateTime, later: DateTime): Int {
            return if (earlier.isBefore(later)) TimeUnit.MILLISECONDS.toDays(later.millis - earlier.millis).toInt()
            else TimeUnit.MILLISECONDS.toDays(earlier.millis - later.millis).toInt()
        }
    }
}
