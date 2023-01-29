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
    /**
     * Reads resources as string from given file name
     *
     * @param name Name with extension that should be read.
     */
    fun readResource(name: String): String
}