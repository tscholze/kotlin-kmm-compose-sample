package io.github.tscholze.cmpsample.utils

/**
 * Multi platform implementation of a User preference / defaults reader
 * to store and read simple objects in user's settings.
 *
 * iOS: iOSMain/utils/
 * Android: androidMain/utils/
 */
expect class UserPreferenceReader() {
    /**
     * Reads string for given key.
     * If key not found, it returns null
     *
     * @param key Key / Id of the value that shall be read.
     * @return Found string or nil
     */
    fun readString(key: String): String?

    /**
     * Stores given string for provided key.
     *
     * @param key Key / Id of the value that shall be stored.
     * @param value The value that shall be stored.
     */
    fun storeString(key: String, value: String?)
}