package io.github.tscholze.cmpsample.utils

import kotlinx.cinterop.*
import platform.Foundation.*
import platform.darwin.NSObject
import platform.darwin.NSObjectMeta

/**
 * Static and stored resource reader.
 * Actual: iOS implementation.
 *
 * Based on: https://luisramos.dev/how-to-share-resources-kmm
 */
actual class ResourceReader {

    // MARK: - Private properties -

    private val bundle: NSBundle = NSBundle.bundleForClass(BundleMarker)

    private class BundleMarker : NSObject() {
        companion object : NSObjectMeta()
    }

    // MARK: - Implementation -

    /**
     * Reads resources as string from given file name
     *
     * @param name Name with extension that should be read.
     */
    actual fun readResource(name: String): String {
        val (filename, type) = when (val lastPeriodIndex = name.lastIndexOf('.')) {
            0 -> {
                null to name.drop(1)
            }
            in 1..Int.MAX_VALUE -> {
                name.take(lastPeriodIndex) to name.drop(lastPeriodIndex + 1)
            }
            else -> {
                name to null
            }
        }
        val path = bundle.pathForResource(filename, type) ?: error(
            "Couldn't get path of $name (parsed as: ${listOfNotNull(filename,type).joinToString(".")})"
        )

        return memScoped {
            val errorPtr = alloc<ObjCObjectVar<NSError?>>()

            NSString.stringWithContentsOfFile(
                path,
                encoding = NSUTF8StringEncoding,
                error = errorPtr.ptr
            ) ?: run {
                error("Couldn't load resource: $name. Error: ${errorPtr.value?.localizedDescription} - ${errorPtr.value}")
            }
        }
    }
}