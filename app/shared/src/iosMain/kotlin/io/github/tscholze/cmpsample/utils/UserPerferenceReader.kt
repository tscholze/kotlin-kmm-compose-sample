package io.github.tscholze.cmpsample.utils

import platform.Foundation.NSUserDefaults

/**
 * Reads and stores values to user defaults.
 * Actual: iOS implementation.
 */
actual class UserPreferenceReader {
    /**
     * Reads string for given key.
     * If key not found, it returns null
     *
     * @param key Key / Id of the value that shall be read.
     * @return Found string or nil
     */
    actual fun readString(key: String): String? {
        return NSUserDefaults.standardUserDefaults.stringForKey(key)
    }

    /**
     * Stores given string for provided key.
     *
     * @param key Key / Id of the value that shall be stored.
     * @param value The value that shall be stored.
     */
    actual fun storeString(key: String, value: String?) {
        if(value == null) {
            NSUserDefaults.standardUserDefaults.removeObjectForKey(key)
        } else {
            NSUserDefaults.standardUserDefaults.setObject(value, key)
        }
    }
}