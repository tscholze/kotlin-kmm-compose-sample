package io.github.tscholze.cmpsample.utils

import android.content.Context
import android.content.SharedPreferences

/**
 * Reads and stores values to user preferences.
 * Actual: Android implementation.
 *
 * Based on: https://github.com/charlee-dev/SharedUI-JetbrainsCompose-Base/search?q=context
 */
actual class UserPreferenceReader {

    // MARK: - Private properties -

    private val sharedPreferences: SharedPreferences =
      Android.context.getSharedPreferences("cmp-sample", Context.MODE_PRIVATE)

    // MARK: - Actual implementations -

    /**
     * Reads string for given key.
     * If key not found, it returns null
     *
     * @param key Key / Id of the value that shall be read.
     * @return Found string or nil
     */
    actual fun readString(key: String): String? {
       return sharedPreferences.getString(key, null)
    }

    /**
     * Stores given string for provided key.
     *
     * @param key Key / Id of the value that shall be stored.
     * @param value The value that shall be stored.
     */
    actual fun storeString(key: String, value: String?) {
        if(value == null) {
            sharedPreferences
                .edit()
                .remove(key)
                .apply()
        } else {
            sharedPreferences
                .edit()
                .putString(key, value)
                .apply()
        }
    }
}