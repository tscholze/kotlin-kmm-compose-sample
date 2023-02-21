package io.github.tscholze.cmpsample.utils

import io.ktor.client.*

/**
 * Multi platform factory for providing a http client with
 * a platform specific engine to work with.
 *
 * Caution:
 *  The engine `CIO` would work in common but does not support
 *  TLS (https) on native targets.
 *
 * iOS: iOSMain/utils/
 * Android: androidMain/utils/
 *
 * @return Created [HttpClient] instance.
 */
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect fun makeHttpClient(): HttpClient