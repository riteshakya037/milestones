package com.ydl.android.data.local

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferenceHelper @Inject constructor(context: Context) {

    private val sharedPreference: SharedPreferences = context.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE)

    companion object {

        private const val PREFERENCE_KEY = "app_preferences"

    }
}
