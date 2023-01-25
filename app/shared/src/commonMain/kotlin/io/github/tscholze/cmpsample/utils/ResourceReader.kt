package io.github.tscholze.cmpsample.utils

/**
 * Multi platform implementation of a ResourceReader
 * to load local (bundled) resources like mock json files.
 *
 * iOS: iOSMain/utils/
 * Android: androidMain/utils/
 */
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect class ResourceReader() {
    fun readResource(name: String): String
}