package io.github.tscholze.cmpsample.utils

import io.ktor.client.*

expect class SampleHttpClient() {
    fun makeClient(): HttpClient
}