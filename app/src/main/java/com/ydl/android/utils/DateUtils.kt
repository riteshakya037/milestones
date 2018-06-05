package com.ydl.android.utils

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

class DateUtils {
    companion object {
        @JvmStatic
        fun getIncomingDateFormat(date: String): DateTime = DateTimeFormat.forPattern("dd MMM, yyyy").parseDateTime(date)


        @JvmStatic
        fun getOutGoingDateFormat(mDate: DateTime): String = DateTimeFormat.forPattern("dd MMM, yyyy").print(mDate)
    }
}
