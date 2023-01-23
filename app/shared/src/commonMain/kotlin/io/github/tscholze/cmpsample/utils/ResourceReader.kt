package io.github.tscholze.cmpsample.utils

expect class ResourceReader() {
    fun readResource(name: String): String
}