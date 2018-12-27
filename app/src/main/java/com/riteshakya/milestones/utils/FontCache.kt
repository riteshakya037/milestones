package com.riteshakya.milestones.utils

import android.content.Context
import android.graphics.Typeface
import java.util.*

object FontCache {

    private val fontCache = Hashtable<String, Typeface>()

    operator fun get(name: String, context: Context): Typeface {
        return if (fontCache.contains(name))
            fontCache[name]!!
        else {
            val tf: Typeface?
            try {
                tf = Typeface.createFromAsset(context.assets, "fonts/$name")
            } catch (e: Exception) {
                throw RuntimeException(e)
            }

            fontCache[name] = tf
            tf
        }
    }
}