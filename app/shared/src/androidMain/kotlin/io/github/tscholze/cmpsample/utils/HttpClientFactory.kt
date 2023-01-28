package io.github.tscholze.cmpsample.utils

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

/**
 * Android implementation a http client with
 * a platform specific engine to work with.
 *
 * Caution:
 * The engine `CIO` would work in common but does not support
 * TLS (https) on native targets.
 *
 * Common: commonMain/utils/
 * iOS: iOSMain/utils/
 */
actual class HttpClientFactory {
    actual fun makeClient(): HttpClient {
        return HttpClient(CIO) {
            // Configure http client.
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
    }
}