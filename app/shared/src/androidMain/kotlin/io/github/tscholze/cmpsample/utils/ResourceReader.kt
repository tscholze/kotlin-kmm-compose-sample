package io.github.tscholze.cmpsample.utils

import java.io.InputStreamReader

/**
 * Static and stored resource reader.
 * Actual: Android implementation.
 *
 * Based on: https://luisramos.dev/how-to-share-resources-kmm
 */
actual class ResourceReader {
    /**
     * Reads resources as string from given file name
     *
     * @param name Name with extension that should be read.
     */
    actual fun readResource(name: String): String =
        javaClass.classLoader!!.getResourceAsStream(name).use { stream ->
            InputStreamReader(stream).use { reader ->
                reader.readText()
            }
        }
}