package com.ydl.android.utils

import java.text.SimpleDateFormat
import java.util.*

class DateUtils {
    companion object {
        @JvmStatic
        fun getIncomingDateFormat(date: String): Date = SimpleDateFormat("yyyy-mm-dd HH:mm:ss", Locale.getDefault()).parse(date)

        @JvmStatic
        fun getDisplayDate(date: Date): String = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(date)

    }

}
